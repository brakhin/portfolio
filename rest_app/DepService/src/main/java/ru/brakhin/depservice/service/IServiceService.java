package ru.brakhin.depservice.service;

import ru.brakhin.depservice.model.Service;

public interface IServiceService {
    Service save(Service service);
    Service findFirstByName(String name);

}
