package ru.brakhin.receiver.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ser")
    @NotNull
    private String ser;

    @Column(name = "number")
    @NotNull
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mvd")
    private Mvd mvd;

    @Column(name = "issuedate")
    @NotNull
    private String issuedate;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "pat")
    @NotNull
    private String pat;

    @Transient
    private Boolean active;


    public Passport(@NotNull String ser, @NotNull String number, Mvd mvd, @NotNull String issuedate,
                    @NotNull String lastname, @NotNull String name, @NotNull String pat) {
        this.ser = ser;
        this.number = number;
        this.mvd = mvd;
        this.issuedate = issuedate;
        this.lastname = lastname;
        this.name = name;
        this.pat = pat;
    }

    public Passport() {
    }


    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Mvd getMvd() {
        return mvd;
    }

    public void setMvd(Mvd mvd) {
        this.mvd = mvd;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id &&
                Objects.equals(ser, passport.ser) &&
                Objects.equals(number, passport.number) &&
                Objects.equals(mvd, passport.mvd) &&
                Objects.equals(issuedate, passport.issuedate) &&
                Objects.equals(lastname, passport.lastname) &&
                Objects.equals(name, passport.name) &&
                Objects.equals(pat, passport.pat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ser, number, mvd, issuedate, lastname, name, pat);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

