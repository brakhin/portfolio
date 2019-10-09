package ru.brakhin.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.brakhin.receiver.models.Passport;
import ru.brakhin.receiver.result.AuthResult;
import ru.brakhin.receiver.result.PassportResult;
import ru.brakhin.receiver.result.ServiceResult;
import ru.brakhin.receiver.web.request.AddDataRequest;
import ru.brakhin.receiver.web.request.AuthenticationRequest;
import ru.brakhin.receiver.web.request.PassportRequest;
import ru.brakhin.receiver.web.request.ServiceRequest;

import java.util.Arrays;
import java.util.List;

import static ru.brakhin.receiver.web.controller.DataController.*;

public class Validator {

    @Autowired
    private RestTemplate restTemplate;

    public Validator() {
    }

    public Boolean validate(AddDataRequest data, List<String> errors) {
        if (!valid(data.getService())) {
            errors.add("Не указана услуга");
        }
        if (!valid(data.getLastname())) {
            errors.add("Не указана фамилия");
        }
        if (!valid(data.getName())) {
            errors.add("Не указано имя");
        }
        if (!valid(data.getPat())) {
            errors.add("Не указано отчество");
        }
        if (!valid(data.getSer())) {
            errors.add("Не указана серия паспорта");
        }
        if (!valid(data.getNum())) {
            errors.add("Не указан номер паспорта");
        }
        if (!valid(data.getDepname())) {
            errors.add("Не указано подразделение, выдавшее паспорт");
        }
        if (!valid(data.getDepcode())) {
            errors.add("Не указан код подразделения, выдавшего паспорт");
        }
        if (!valid(data.getIssuedate())) {
            errors.add("Не указана дата выдачи паспорта");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Валидация паспорта по базе МВД
        try {
            // получение токена от сервиса МВД
            AuthenticationRequest authRequest = new AuthenticationRequest("user", "password");
            HttpEntity<AuthenticationRequest> authRequestBody =
                    new HttpEntity<AuthenticationRequest>(authRequest, headers);

            ResponseEntity<AuthResult> responceFromAuth = restTemplate.postForEntity(
                    "http://localhost:8082/auth/signin",
                    authRequestBody,
                    AuthResult.class);

            String mvdToken = responceFromAuth.getBody().getToken();
            headers.set("Authorization", "Bearer "+ mvdToken);

            // получение полезных данных от сервиса МВД
            PassportRequest passportRequest = new PassportRequest(data.getSer(), data.getNum());
            HttpEntity<PassportRequest> requestBody = new HttpEntity<PassportRequest>(passportRequest, headers);
            PassportResult responceFromMvd = restTemplate.postForObject(
                    URL_PASSPORT_FROM_MVD,
                    requestBody,
                    PassportResult.class);

            if (responceFromMvd.getErrorText() != null) {
                errors.addAll(responceFromMvd.getErrorText());
            }

            Passport passportFromMvd = responceFromMvd.getPassport();
            if (passportFromMvd != null) {
                if (!passportFromMvd.getActive()) {
                    errors.add("База МВД : Паспорт недействителен");
                }
                if (!passportFromMvd.getLastname().equals(data.getLastname())
                        ||
                        !passportFromMvd.getName().equals(data.getName())
                        ||
                        !passportFromMvd.getPat().equals(data.getPat())
                ) {
                    errors.add("База МВД : Паспорт принадлежит другому лицу");
                }
            }
        } catch (ResourceAccessException e) {
            errors.add("База МВД : Нет связи, попробуйте позже");
        }

        // Валидация паспорта по базе Департамента
        try {
            // получение токена от сервиса МВД
            AuthenticationRequest authRequest = new AuthenticationRequest("user", "password");
            HttpEntity<AuthenticationRequest> authRequestBody =
                    new HttpEntity<AuthenticationRequest>(authRequest, headers);

            ResponseEntity<AuthResult> responceFromAuth = restTemplate.postForEntity(
                    "http://localhost:8083/auth/signin",
                    authRequestBody,
                    AuthResult.class);

            String depToken = responceFromAuth.getBody().getToken();
            headers.set("Authorization", "Bearer "+ depToken);

            ServiceRequest serviceRequest = new ServiceRequest(data.getService());
            HttpEntity<ServiceRequest> requestBody = new HttpEntity<ServiceRequest>(serviceRequest, headers);
            ServiceResult responceFromDep = restTemplate.postForObject(
                    URL_SERVICE_FROM_DEP,
                    requestBody,
                    ServiceResult.class);

            if (responceFromDep.getErrorCode() != ERROR_OK) {
                errors.add(String.format("База Департамента : услуга '%s' не является допустимой", data.getService()));
            }
        } catch (ResourceAccessException e) {
            errors.add("База Департамента : Нет связи, попробуйте позже");
        }


        return errors.size() == 0;
    }

    private boolean valid(Object value) {
        return value != null
                && (value.getClass() == String.class && !((String)value).isEmpty() || value.getClass() == Integer.class);
    }

}
