package ru.brakhin.mvdservice.web;

public class PassportRequest {

    private String ser;
    private String num;

    public PassportRequest() {
    }

    public PassportRequest(String ser, String num) {
        this.ser = ser;
        this.num = num;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
