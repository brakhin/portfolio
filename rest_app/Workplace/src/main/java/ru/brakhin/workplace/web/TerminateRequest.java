package ru.brakhin.workplace.web;

import java.io.Serializable;

public class TerminateRequest implements Serializable {

    private static final long serialVersionUID = -2353655674519692715L;
    private Long id;

    public TerminateRequest() {
    }

    public TerminateRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
