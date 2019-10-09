package ru.brakhin.workplace.pojo;

public class PassportPOJO {
    private Integer ser;
    private Integer number;
    private String depname;
    private String code;
    private String issuedate;
    private String lastname;
    private String name;
    private String pat;

    public PassportPOJO() {
    }

    public PassportPOJO(Integer ser, Integer number, String depname, String code, String issuedate, String lastname, String name, String pat) {
        this.ser = ser;
        this.number = number;
        this.depname = depname;
        this.code = code;
        this.issuedate = issuedate;
        this.lastname = lastname;
        this.name = name;
        this.pat = pat;
    }

    public Integer getSer() {
        return ser;
    }

    public void setSer(Integer ser) {
        this.ser = ser;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
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
}
