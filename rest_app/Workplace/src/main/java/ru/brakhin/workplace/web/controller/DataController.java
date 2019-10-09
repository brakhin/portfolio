package ru.brakhin.workplace.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.brakhin.workplace.Validator;
import ru.brakhin.workplace.model.Passport;
import ru.brakhin.workplace.model.Request;
import ru.brakhin.workplace.pojo.PassportPOJO;
import ru.brakhin.workplace.pojo.ResultPOJO;
import ru.brakhin.workplace.result.SearchResult;
import ru.brakhin.workplace.result.DetailedResult;
import ru.brakhin.workplace.result.TerminatedResult;
import ru.brakhin.workplace.service.IRequestService;
import ru.brakhin.workplace.web.DetailedRequest;
import ru.brakhin.workplace.web.FilterRequest;
import ru.brakhin.workplace.web.TerminateRequest;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/request")
public class DataController {
    private final static Integer ERROR_OK = 0;
    private final static Integer ERROR_BADDATA = 1;
    private final static Integer ERROR_NOTFOUND = 3;

    @Autowired
    private IRequestService requestService;

    @Autowired
    private Validator validator;

    @PostMapping("/search")
    public SearchResult searchData(@RequestBody FilterRequest data) {
        SearchResult searchResult = null;
        List<Object> resultList = null;

        List<String> validateErrors = new ArrayList<>();
        if (validator.validate(data, validateErrors)) {
            if ("fio".equals(data.getSearchType())) {
                resultList = requestService.findByFioAndSortBy(data.getFio() + "%", data.getOrderIndex());
            } else if ("date".equals(data.getSearchType())) {
                resultList = requestService.findByDateAndSortBy(data.getDate(), data.getOrderIndex());
            } else if ("state".equals(data.getSearchType())) {
                if (!"all".equals(data.getState())) {
                    resultList = requestService.findByStateAndSortBy(!"active".equals(data.getState()), data.getOrderIndex());
                } else {
                    resultList = requestService.findAllSortBy(data.getOrderIndex());
                }
            } else if ("service".equals(data.getSearchType())) {
                resultList = requestService.findByServiceAndSortBy(data.getService(), data.getOrderIndex());
            }
            searchResult = new SearchResult(ERROR_OK, resultList,null);
        } else {
            searchResult = new SearchResult(ERROR_BADDATA, null, validateErrors);
        }
        return searchResult;
    }

    @GetMapping("/detailed")
    public DetailedResult detailedData(@RequestBody DetailedRequest data) {
        ResultPOJO result = null;
        Request request = requestService.findById(data.getId());

        if (request != null) {
            Passport passportDB = request.getPassport();
            PassportPOJO passport = new PassportPOJO(passportDB.getSer(), passportDB.getNumber(),
                    passportDB.getMvd().getDepname(), passportDB.getMvd().getCode(), passportDB.getIssuedate(),
                    passportDB.getLastname(), passportDB.getName(), passportDB.getPat());

            result = new ResultPOJO(request.getId(),
                    new SimpleDateFormat("dd-MM-yyyy").format(request.getDate()), request.getTerminated(),
                    passport, request.getService().getName());
            return new DetailedResult(ERROR_OK, result,null);
        } else {
            List<String> list = new ArrayList<>();
            list.add("Запись не найдена");
            return new DetailedResult(ERROR_NOTFOUND, null, list);
        }
    }

    @PostMapping("/terminate")
    public TerminatedResult detailedData(@RequestBody TerminateRequest data) {
        Request request = requestService.findById(data.getId());
        if (request == null) {
            return new TerminatedResult(ERROR_NOTFOUND, "Запись не найдена");
        } else {
            request.setTerminated(true);
            requestService.save(request);
            return new TerminatedResult(ERROR_OK, "Запись терминирована");
        }
    }
}