package ru.brakhin.receiver.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.receiver.models.Request;

public interface IRequestRepository extends CrudRepository<Request, Integer> {
}
