package ru.brakhin.receiver.result;

public class ServiceResult {

    private int errorCode;

    public ServiceResult(int errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceResult() {
    }

    public int getErrorCode() {
        return errorCode;
    }
}