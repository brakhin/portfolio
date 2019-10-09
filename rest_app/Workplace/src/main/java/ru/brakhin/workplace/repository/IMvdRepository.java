package ru.brakhin.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.workplace.model.Mvd;

public interface IMvdRepository extends CrudRepository<Mvd, Integer> {
}
