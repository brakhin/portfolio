package ru.brakhin.mvdservice;

import ru.brakhin.mvdservice.web.PassportRequest;
import java.util.List;

public class Validator {

    public Validator() {
    }

    public Boolean validate(PassportRequest data, List<String> errors) {
        if (!valid(data.getSer())) {
            errors.add("Не указана серия паспорта");
        }
        if (!valid(data.getNum())) {
            errors.add("Не указан номер паспорта");
        }
        return errors.size() == 0;
    }

    private boolean valid(Object value) {
        return value != null
                && (value.getClass() == String.class && !((String)value).isEmpty() || value.getClass() == Integer.class);
    }
}
