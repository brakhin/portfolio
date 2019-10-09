package ru.brakhin.receiver.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.receiver.models.Mvd;

public interface IMvdRepository extends CrudRepository<Mvd, Integer> {
}
