package ru.brakhin.mvdservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.mvdservice.model.Mvd;

public interface IMvdRepository extends CrudRepository<Mvd, Integer> {
}
