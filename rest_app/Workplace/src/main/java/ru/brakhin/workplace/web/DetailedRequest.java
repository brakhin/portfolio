package ru.brakhin.workplace.web;

import java.io.Serializable;

public class DetailedRequest implements Serializable {

    private static final long serialVersionUID = -7041938037184733434L;
    private Long id;

    public DetailedRequest() {
    }

    public DetailedRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
