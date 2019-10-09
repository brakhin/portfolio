package ru.brakhin.depservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.brakhin.depservice.result.ServiceResult;
import ru.brakhin.depservice.service.IServiceService;
import ru.brakhin.depservice.web.ServiceRequest;

@RestController
@RequestMapping("/api/service")
public class DataController {
    private final static Integer ERROR_OK = 0;
    private final static Integer ERROR_BADDATA = 1;

    @Autowired
    IServiceService serviceService;

    @PostMapping("/search")
    public ServiceResult addData(@RequestBody ServiceRequest data) {
        return new ServiceResult(serviceService.findFirstByName(data.getName()) == null ? ERROR_BADDATA : ERROR_OK);
    }
}