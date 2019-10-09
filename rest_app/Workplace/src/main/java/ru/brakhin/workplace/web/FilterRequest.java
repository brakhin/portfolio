package ru.brakhin.workplace.web;

import java.io.Serializable;

public class FilterRequest implements Serializable {

    private static final long serialVersionUID = 5940915842965905671L;
    private String searchType;
    private String date;
    private String fio;
    private String service;
    private String state;
    private Integer orderIndex;

    public FilterRequest() {
    }

    public FilterRequest(String searchType, String date, String fio, String service, String state, Integer orderIndex) {
        this.searchType = searchType;
        this.date = date;
        this.fio = fio;
        this.service = service;
        this.state = state;
        this.orderIndex = orderIndex;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
