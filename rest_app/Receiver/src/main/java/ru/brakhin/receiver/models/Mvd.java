package ru.brakhin.receiver.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "mvd")
public class Mvd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "depname")
    @NotNull
    private String depname;

    @Column(name = "depcode")
    @NotNull
    private String code;

    public Mvd(@NotNull String depname, @NotNull String code) {
        this.depname = depname;
        this.code = code;
    }

    public Mvd() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mvd mvd = (Mvd) o;
        return id == mvd.id &&
                Objects.equals(depname, mvd.depname) &&
                Objects.equals(code, mvd.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, depname, code);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

