package ru.brakhin.workplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.brakhin.workplace.model.Request;
import ru.brakhin.workplace.repository.IRequestRepository;

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

    @Override
    public List<Object> findByFioAndSortBy(String filter, Integer orderIndex) {
        return requestRepository.findByFioAndSortBy(filter, orderIndex);
    }

    @Override
    public List<Object> findByDateAndSortBy(String filter, Integer orderIndex) {
        return requestRepository.findByDateAndSortBy(filter, orderIndex);
    }

    @Override
    public List<Object> findByStateAndSortBy(Boolean filter, Integer orderIndex) {
        return requestRepository.findByStateAndSortBy(filter, orderIndex);
    }

    @Override
    public List<Object> findAllSortBy(Integer orderIndex) {
        return requestRepository.findAllSortBy(orderIndex);
    }

    @Override
    public List<Object> findByServiceAndSortBy(String filter, Integer orderIndex) {
        return requestRepository.findByServiceAndSortBy(filter, orderIndex);
    }

    @Override
    public Request findById(Long id) {
        return requestRepository.findById(id);
    }
}
