package com.casamatechs.koreannumbers.json;

/**
 * POJO for /api/checkNumber/:number POST method response
 */
public class ResultResponse {

    private int responseId;

    private String response;

    private String receivedSino;

    private String expectedSino;

    private String receivedNative;

    private String expectedNative;

    private int number;

    public ResultResponse() {

    }

    public ResultResponse(int responseId, String response, String receivedSino, String expectedSino, String receivedNative, String expectedNative, int number) {
        this.responseId = responseId;
        this.response = response;
        this.receivedSino = receivedSino;
        this.expectedSino = expectedSino;
        this.receivedNative = receivedNative;
        this.expectedNative = expectedNative;
        this.number = number;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getReceivedSino() {
        return receivedSino;
    }

    public void setReceivedSino(String receivedSino) {
        this.receivedSino = receivedSino;
    }

    public String getExpectedSino() {
        return expectedSino;
    }

    public void setExpectedSino(String expectedSino) {
        this.expectedSino = expectedSino;
    }

    public String getReceivedNative() {
        return receivedNative;
    }

    public void setReceivedNative(String receivedNative) {
        this.receivedNative = receivedNative;
    }

    public String getExpectedNative() {
        return expectedNative;
    }

    public void setExpectedNative(String expectedNative) {
        this.expectedNative = expectedNative;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
