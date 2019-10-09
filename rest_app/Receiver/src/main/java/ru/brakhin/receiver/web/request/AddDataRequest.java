package ru.brakhin.receiver.web.request;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AddDataRequest  {

    private List<String> files;
    private List<String> descriptions;
    private String service;
    private String lastname;
    private String name;
    private String pat;
    private String ser;
    private String num;
    private String depname;
    private String depcode;
    private String issuedate;

    public AddDataRequest() {
    }

    public AddDataRequest(List<String> files, List<String> descriptions, String service, String lastname,
                          String name, String pat, String ser, String num, String depname, String depcode,
                          String issuedate) {
        this.files = files;
        this.descriptions = descriptions;
        this.service = service;
        this.lastname = lastname;
        this.name = name;
        this.pat = pat;
        this.ser = ser;
        this.num = num;
        this.depname = depname;
        this.depcode = depcode;
        this.issuedate = issuedate;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddDataRequest that = (AddDataRequest) o;
        return Objects.equals(files, that.files) &&
                Objects.equals(descriptions, that.descriptions) &&
                Objects.equals(service, that.service) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(pat, that.pat) &&
                Objects.equals(ser, that.ser) &&
                Objects.equals(num, that.num) &&
                Objects.equals(depname, that.depname) &&
                Objects.equals(depcode, that.depcode) &&
                Objects.equals(issuedate, that.issuedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(files, descriptions, service, lastname, name, pat, ser, num, depname, depcode, issuedate);
    }
}
