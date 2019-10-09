package ru.brakhin.receiver.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.receiver.models.Service;

public interface IServiceRepository extends CrudRepository<Service, Integer> {
}
