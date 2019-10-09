package ru.brakhin.mvdservice.model;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Mvd{" +
                "id=" + id +
                ", depname='" + depname + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

