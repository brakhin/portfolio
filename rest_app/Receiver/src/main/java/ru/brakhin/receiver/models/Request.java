package ru.brakhin.receiver.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "req_date")
    @NotNull
    private Timestamp date;

    @Column(name = "terminated")
    private Boolean terminated;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_passport")
    private Passport passport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_service")
    private Service service;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Attachment> attachments = new HashSet<>();

    public Request(@NotNull Timestamp date, Passport passport, Service service) {
        this.date = date;
        this.passport = passport;
        this.service = service;
    }

    public Request() {
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public Boolean getTerminated() {
        return terminated == null ? false : true;
    }

    public void setTerminated(Boolean terminated) {
        this.terminated = terminated;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}



