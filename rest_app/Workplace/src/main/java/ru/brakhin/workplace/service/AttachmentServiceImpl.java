package ru.brakhin.workplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.brakhin.workplace.model.Attachment;
import ru.brakhin.workplace.repository.IAttachRepository;

@Service
@Repository
public class AttachmentServiceImpl implements IAttachmentService {

    @Autowired
    private IAttachRepository attachRepository;

    @Override
    public Attachment save(Attachment attachment) {
        return attachRepository.save(attachment);
    }
}
