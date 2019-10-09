package ru.brakhin.receiver.service;

import ru.brakhin.receiver.models.Request;

import java.util.List;

public interface IRequestService {
    Request save(Request request);
    List<Request> findAll();
}
