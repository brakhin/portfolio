package ru.brakhin.workplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.brakhin.workplace.model.Service;
import ru.brakhin.workplace.repository.IServiceRepository;

@org.springframework.stereotype.Service
@Repository
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }
}
