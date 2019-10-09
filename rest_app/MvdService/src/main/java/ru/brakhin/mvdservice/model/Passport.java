package ru.brakhin.mvdservice.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    private Timestamp issuedate;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "pat")
    @NotNull
    private String pat;

    @Column(name = "active")
    @NotNull
    private Boolean active;

    public Passport() {
    }

    public Passport(@NotNull String ser, @NotNull String number, Mvd mvd, @NotNull String issuedate,
                    @NotNull String lastname, @NotNull String name, @NotNull String pat, @NotNull Boolean active) {
        this.ser = ser;
        this.number = number;
        this.mvd = mvd;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date parsedDate = dateFormat.parse(issuedate);
            this.issuedate = new Timestamp(parsedDate.getTime());
        } catch(Exception e) {
            this.issuedate = null;
        }

        this.lastname = lastname;
        this.name = name;
        this.pat = pat;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Timestamp getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Timestamp issuedate) {
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
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", ser=" + ser +
                ", number=" + number +
                ", mvd=" + mvd +
                ", issuedate=" + issuedate +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", pat='" + pat + '\'' +
                ", active=" + active +
                '}';
    }
}

