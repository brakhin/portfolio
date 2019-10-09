package ru.brakhin.receiver.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.receiver.models.Passport;

public interface IPassportRepository extends CrudRepository<Passport, Integer> {
}
