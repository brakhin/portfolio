package ru.brakhin.workplace.result;

import ru.brakhin.workplace.pojo.ResultPOJO;

import java.util.List;

public class DetailedResult {
    private final int errorCode;
    private final ResultPOJO result;
    private final List<String> errorText;

    public DetailedResult(int errorCode, ResultPOJO result, List<String> errorText) {
        this.errorCode = errorCode;
        this.result = result;
        this.errorText = errorText;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public ResultPOJO getResult() {
        return result;
    }
    public List<String> getErrorText() {
        return errorText;
    }
}
