package ru.brakhin.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.workplace.model.Attachment;

public interface IAttachRepository extends CrudRepository<Attachment, Integer> {
}
