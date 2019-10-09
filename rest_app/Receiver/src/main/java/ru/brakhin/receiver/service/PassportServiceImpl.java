package ru.brakhin.receiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.brakhin.receiver.models.Passport;
import ru.brakhin.receiver.repository.IPassportRepository;

@Service
@Repository
public class PassportServiceImpl implements IPassportService {

    @Autowired
    private IPassportRepository passportRepository;

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }
}
