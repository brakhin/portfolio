package ru.brakhin.workplace;

import ru.brakhin.workplace.web.FilterRequest;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public Validator() {
    }

    public Boolean validate(FilterRequest data, List<String> errors) {
        if (!Arrays.asList("active", "inactive", "all").contains(data.getState())) {
            errors.add("Недопустимое значение статуса (state)");
        }
        if (data.getOrderIndex() < 1 || data.getOrderIndex() > 4) {
            errors.add("Номер поля для сортировки (orderIndex) должно быть от 1 до 4");
        }
        if (!Arrays.asList("date", "fio", "service", "state").contains(data.getSearchType())) {
            errors.add("Недопустимое значение типа поиска (searchType)");
        }
        return errors.size() == 0;
    }
}
