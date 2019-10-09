package ru.brakhin.mvdservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.mvdservice.model.Passport;

public interface IPassportRepository extends CrudRepository<Passport, Integer> {
    Passport findPassportBySerAndNumber(String ser, String num);
}
