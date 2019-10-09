package ru.brakhin.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.workplace.model.Passport;

public interface IPassportRepository extends CrudRepository<Passport, Integer> {
}
