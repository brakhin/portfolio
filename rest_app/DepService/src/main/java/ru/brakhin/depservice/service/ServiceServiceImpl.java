package ru.brakhin.depservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.brakhin.depservice.model.Service;
import ru.brakhin.depservice.repository.IServiceRepository;

@org.springframework.stereotype.Service
@Repository
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service findFirstByName(String name) {
        return serviceRepository.findFirstByName(name);
    }
}
