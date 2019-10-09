package ru.brakhin.receiver.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.brakhin.receiver.Validator;
import ru.brakhin.receiver.result.DataResult;
import ru.brakhin.receiver.result.PassportResult;
import ru.brakhin.receiver.models.*;
import ru.brakhin.receiver.result.ServiceResult;
import ru.brakhin.receiver.service.IAttachmentService;
import ru.brakhin.receiver.service.IRequestService;
import ru.brakhin.receiver.web.request.AddDataRequest;
import ru.brakhin.receiver.web.request.PassportRequest;
import ru.brakhin.receiver.web.request.ServiceRequest;

@RestController
@RequestMapping("/api/request")
@Slf4j
public class DataController {
    public final static Integer ERROR_OK = 0;
    public final static Integer ERROR_BADDATA = 1;
    public final static Integer ERROR_SYSTEM = 2;

    public static final String URL_PASSPORT_FROM_MVD = "http://localhost:8082/api/service/search";
    public static final String URL_SERVICE_FROM_DEP  = "http://localhost:8083/api/service/search";

    @Autowired
    private IRequestService requestService;

    @Autowired
    private IAttachmentService attachService;

    @Autowired
    private Environment env;

    @Autowired
    private Validator validator;

    public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/attached_docs/";

    @PostMapping("/new")
    public DataResult addData(@RequestBody AddDataRequest data) {
        DataResult dataResult;
        List<String> validateErrors = new ArrayList<>();
        if (validator.validate(data, validateErrors)) {
            if (saveAttaches(data)) {
                saveData(data);
                dataResult = new DataResult(ERROR_OK, null);
            } else {
                dataResult = new DataResult(ERROR_SYSTEM, null);
            }
        } else {
            dataResult = new DataResult(ERROR_BADDATA, validateErrors);
        }
        log.info(String.format("Add data request result code is %d", dataResult.getErrorCode()));
        return dataResult;
    }

    private Boolean saveAttaches(AddDataRequest data) {
        Boolean result = true;

        Boolean dontSaveAttachments = "true".equals(env.getProperty("dont_save_attachments"));
        if (!dontSaveAttachments) {
            File file = new File(UPLOAD_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        List<String> filesData = data.getFiles();
        if (filesData != null && filesData.size() > 0) {
            for (int i = 0; i < filesData.size(); i++) {
                byte[] base64data = Base64.decodeBase64(filesData.get(i));
                String uid = UUID.randomUUID().toString();
                if (!dontSaveAttachments) {
                    String filename = UPLOAD_DIR + uid + ".jpg";
                    try (OutputStream stream = new FileOutputStream(filename)) {
                        stream.write(base64data);
                        filesData.set(i, new File(filename).getName());
                    } catch (IOException e) {
                        filesData.set(i, "");
                        log.error(e.getMessage(), e);
                        result = false;
                    }
                } else {
                    filesData.set(i, uid + ".jpg");
                }
            }
        }
        return result;
    }

    private void saveData(AddDataRequest data) {
        Mvd mvd = new Mvd(data.getDepname(), data.getDepcode());
        Passport passport = new Passport(data.getSer(), data.getNum(), mvd, data.getIssuedate(),
                data.getLastname(), data.getName(), data.getPat());
        Service service = new Service(data.getService());

        Request request = new Request(new Timestamp(System.currentTimeMillis()), passport, service);
        requestService.save(request);

        for (int i = 0; i < data.getFiles().size(); i++) {
            String fileName = data.getFiles().get(i);
            if (fileName != null && ! fileName.isEmpty()) {
                String description = data.getDescriptions() != null && i < data.getDescriptions().size()
                        && data.getDescriptions().get(i) != null
                        ?
                        data.getDescriptions().get(i)
                        :
                        "";
                attachService.save(new Attachment(fileName,
                        description.isEmpty() ? String.format("Документ № %d", i + 1) : description, request));
            }
        }
    }
}