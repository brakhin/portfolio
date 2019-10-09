package ru.brakhin.mvdservice.result;

import ru.brakhin.mvdservice.model.Passport;

import java.util.List;

public class PassportResult {

    private final int errorCode;
    private final Passport passport;
    private final List<String> errorText;

    public PassportResult(int errorCode, Passport passport, List<String> errorText) {
        this.errorCode = errorCode;
        this.passport = passport;
        this.errorText = errorText;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Passport getPassport() {
        return passport;
    }

    public List<String> getErrorText() {
        return errorText;
    }
}