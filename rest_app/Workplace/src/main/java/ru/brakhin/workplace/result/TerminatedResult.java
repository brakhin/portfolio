package ru.brakhin.workplace.result;

public class TerminatedResult {
    private final int errorCode;
    private final String errorText;

    public TerminatedResult(int errorCode, String errorText) {
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorText() {
        return errorText;
    }
}
