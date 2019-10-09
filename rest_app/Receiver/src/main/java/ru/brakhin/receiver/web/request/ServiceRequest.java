package ru.brakhin.receiver.web.request;

import java.io.Serializable;

public class ServiceRequest {

    private String name;

    public ServiceRequest() {
    }

    public ServiceRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
