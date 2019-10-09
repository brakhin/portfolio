package ru.brakhin.receiver.result;

import ru.brakhin.receiver.models.Passport;

import java.io.Serializable;
import java.util.List;

public class PassportResult implements Serializable {

    private static final long serialVersionUID = -7808525335945340235L;

    private  int errorCode;
    private  Passport passport;
    private  List<String> errorText;

    public PassportResult(int errorCode, Passport passport, List<String> errorText) {
        this.errorCode = errorCode;
        this.passport = passport;
        this.errorText = errorText;
    }

    public PassportResult() {
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