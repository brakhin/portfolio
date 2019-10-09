package ru.brakhin.workplace.service;

import ru.brakhin.workplace.model.Request;

import java.util.List;

public interface IRequestService {
    Request save(Request request);
    List<Request> findAll();
    List<Object> findByFioAndSortBy(String filter, Integer orderIndex);
    List<Object> findByDateAndSortBy(String filter, Integer orderIndex);
    List<Object> findByStateAndSortBy(Boolean filter, Integer orderIndex);
    List<Object> findAllSortBy(Integer orderIndex);
    List<Object> findByServiceAndSortBy(String filter, Integer orderIndex);
    Request findById(Long id);
}
