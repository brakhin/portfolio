package ru.brakhin.depservice.web;

import java.io.Serializable;

public class ServiceRequest implements Serializable {

    private static final long serialVersionUID = 7845734278406367094L;
    private String name;

    public ServiceRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
