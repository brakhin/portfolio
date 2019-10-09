package ru.brakhin.depservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.depservice.model.Service;

public interface IServiceRepository extends CrudRepository<Service, Integer> {
    Service findFirstByName(String name);
}
