package ru.brakhin.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.workplace.model.Service;

public interface IServiceRepository extends CrudRepository<Service, Integer> {
}
