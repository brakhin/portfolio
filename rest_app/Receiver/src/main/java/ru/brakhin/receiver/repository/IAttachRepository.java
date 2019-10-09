package ru.brakhin.receiver.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.receiver.models.Attachment;

public interface IAttachRepository extends CrudRepository<Attachment, Integer> {
}
