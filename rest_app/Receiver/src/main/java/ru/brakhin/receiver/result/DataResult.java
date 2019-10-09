package ru.brakhin.receiver.result;

import java.util.List;

public class DataResult {

    private final int errorCode;
    private final List<String> errorText;

    public DataResult(int errorCode, List<String> errorText) {
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public List<String> getErrorText() {
        return errorText;
    }
}