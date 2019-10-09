package ru.brakhin.workplace.pojo;

import java.util.Set;

public class ResultPOJO {
    private Long id;
    private String date;
    private Boolean terminated;
    private PassportPOJO passport;
    private String serviceName;

    public ResultPOJO(Long id, String date, Boolean terminated, PassportPOJO passport, String serviceName) {
        this.id = id;
        this.date = date;
        this.terminated = terminated;
        this.passport = passport;
        this.serviceName = serviceName;
    }

    public ResultPOJO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getTerminated() {
        return terminated;
    }

    public void setTerminated(Boolean terminated) {
        this.terminated = terminated;
    }

    public PassportPOJO getPassport() {
        return passport;
    }

    public void setPassport(PassportPOJO passport) {
        this.passport = passport;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
