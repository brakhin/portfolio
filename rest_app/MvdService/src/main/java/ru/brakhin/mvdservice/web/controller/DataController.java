package ru.brakhin.mvdservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.brakhin.mvdservice.Validator;
import ru.brakhin.mvdservice.model.Passport;
import ru.brakhin.mvdservice.result.PassportResult;
import ru.brakhin.mvdservice.service.IPassportService;
import ru.brakhin.mvdservice.web.PassportRequest;

import java.util.*;

@RestController
@RequestMapping("/api/service")
public class DataController {
    private final static Integer ERROR_OK = 0;
    private final static Integer ERROR_BADDATA = 1;

    @Autowired
    IPassportService passportService;

    @Autowired
    private Validator validator;

    @PostMapping("/search")
    public PassportResult addData(@RequestBody PassportRequest data) {
        PassportResult passportResult;
        List<String> validateErrors = new ArrayList<>();
        if (validator.validate(data, validateErrors)) {
            Passport passport = passportService.findPassportBySerAndNumber(data.getSer(), data.getNum());
            if (passport == null) {
                List<String> errors = new ArrayList<>();
                errors.add("База МВД : паспорт не найден");
                passportResult = new PassportResult(ERROR_BADDATA, null, errors);
            } else {
                passportResult = new PassportResult(ERROR_OK, passport, null);
            }
        } else {
            passportResult = new PassportResult(ERROR_BADDATA, null, validateErrors);
        }
        return passportResult;
    }
}