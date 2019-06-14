package com.casamatechs.koreannumbers;

import com.casamatechs.koreannumbers.commons.Calculator;
import com.casamatechs.koreannumbers.commons.NumberType;
import com.casamatechs.koreannumbers.json.NumberRequest;
import com.casamatechs.koreannumbers.json.NumberResponse;
import com.casamatechs.koreannumbers.json.ResultResponse;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.Random;

import static com.casamatechs.koreannumbers.commons.Constants.*;

public class KoreanRESTVerticle extends AbstractVerticle {

    private static final Random numberGenerator = new Random();

    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);
        router.get("/api/getNumber").handler(routingContext ->
                routingContext.response()
                        .putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
                        .end(Json.encodePrettily(new NumberRequest(numberGenerator.nextInt(1000))))
        );
        router.route("/api/checkNumber*")
                .handler(BodyHandler.create());
        router.post("/api/checkNumber/:number")
                .handler(routingContext -> {
                    final int number = Integer.parseInt(routingContext.request().getParam("number"));
                    final NumberResponse response = Json.decodeValue(routingContext.getBodyAsString(),
                            NumberResponse.class);
                    this.checkNumbers(routingContext, number, response);
                });
        vertx
                .createHttpServer()
                .requestHandler(router::handle)
                .listen(config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }

    private void checkNumbers(final RoutingContext routingContext, final int number, final NumberResponse response) {
        final String expectedSino = Calculator.getResult(number, NumberType.SINO);
        final String expectedNative = Calculator.getResult(number, NumberType.NATIVE);
        final ResultResponse resultResponse = new ResultResponse(0, null, response.getSinoNumber(),
                expectedSino, response.getNativeNumber(), expectedNative, number);
        routingContext.response()
                .putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .setStatusCode(202);
        if (response.getNativeNumber().equals(expectedNative) &&
                response.getSinoNumber().equals(expectedSino)) {
            resultResponse.setResponseId(CHECK_CORRECT);
            resultResponse.setResponse("You wrote both native and sino korean numbers well! Congrats!");
        } else if (!response.getNativeNumber().equals(expectedNative) &&
                !response.getSinoNumber().equals(expectedSino)) {
            resultResponse.setResponseId(CHECK_BOTH_INCORRECT);
            resultResponse.setResponse("You wrote both native and sino korean numbers in a wrong way. You have to study more!");
        } else if (!response.getNativeNumber().equals(expectedNative)) {
            resultResponse.setResponseId(CHECK_NATIVE_INCORRECT);
            resultResponse.setResponse("You wrote the native korean number in a wrong way.");
        } else {
            resultResponse.setResponseId(CHECK_SINO_INCORRECT);
            resultResponse.setResponse("You wrote the sino korean number in a wrong way.");
        }
        routingContext.response().end(Json.encodePrettily(resultResponse));

    }
}
