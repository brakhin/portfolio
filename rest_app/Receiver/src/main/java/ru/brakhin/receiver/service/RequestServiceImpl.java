package ru.brakhin.receiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.brakhin.receiver.models.Request;
import ru.brakhin.receiver.repository.IRequestRepository;

import java.util.List;

@Service
@Repository
public class RequestServiceImpl implements IRequestService {

    @Autowired
    private IRequestRepository requestRepository;

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        return (List<Request>) requestRepository.findAll();
    }
}
