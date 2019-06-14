package com.casamatechs.koreannumbers.json;

/**
 * POJO for /api/getNumber GET method response
 */
public class NumberRequest {

    private int number;

    public NumberRequest() {

    }

    public NumberRequest(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
