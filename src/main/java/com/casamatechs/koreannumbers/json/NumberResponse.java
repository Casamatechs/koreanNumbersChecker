package com.casamatechs.koreannumbers.json;

/**
 * POJO for /api/checkNumber/:number POST method request body
 */
public class NumberResponse {

    private String sinoNumber;

    private String nativeNumber;

    public NumberResponse() {

    }

    public NumberResponse(String sinoNumber, String nativeNumber) {
        this.sinoNumber = sinoNumber;
        this.nativeNumber = nativeNumber;
    }

    public String getSinoNumber() {
        return sinoNumber;
    }

    public void setSinoNumber(String sinoNumber) {
        this.sinoNumber = sinoNumber;
    }

    public String getNativeNumber() {
        return nativeNumber;
    }

    public void setNativeNumber(String nativeNumber) {
        this.nativeNumber = nativeNumber;
    }
}
