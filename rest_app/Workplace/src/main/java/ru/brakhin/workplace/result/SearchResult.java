package ru.brakhin.workplace.result;

import java.util.List;

public class SearchResult {

    private final int errorCode;
    private final List<Object> resultList;
    private final List<String> errorText;

    public SearchResult(int errorCode, List<Object> resultList, List<String> errorText) {
        this.errorCode = errorCode;
        this.resultList = resultList;
        this.errorText = errorText;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public List<Object> getResultList() {
        return resultList;
    }

    public List<String> getErrorText() {
        return errorText;
    }
}