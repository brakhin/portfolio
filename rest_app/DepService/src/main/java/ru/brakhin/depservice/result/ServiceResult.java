package ru.brakhin.depservice.result;

public class ServiceResult {

    private final int errorCode;

    public ServiceResult(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}