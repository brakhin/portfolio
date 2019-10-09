package ru.brakhin.receiver.result;

import ru.brakhin.receiver.models.Passport;

import java.io.Serializable;
import java.util.List;

public class AuthResult implements Serializable {

    private static final long serialVersionUID = -8833225391610863664L;

    private  String username;
    private  String token;

    public AuthResult() {
    }

    public AuthResult(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}