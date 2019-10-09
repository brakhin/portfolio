package ru.brakhin.mvdservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.brakhin.mvdservice.model.Passport;
import ru.brakhin.mvdservice.repository.IPassportRepository;

@Service
@Repository
public class PassportServiceImpl implements IPassportService {

    @Autowired
    private IPassportRepository passportRepository;

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport findPassportBySerAndNumber(String ser, String num) {
        return passportRepository.findPassportBySerAndNumber(ser, num);
    }

}
