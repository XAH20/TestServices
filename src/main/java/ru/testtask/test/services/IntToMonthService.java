package ru.testtask.test.services;

import org.springframework.stereotype.Service;
import ru.testtask.test.model.GetMonthRequest;
import ru.testtask.test.model.MonthResponce;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IntToMonthService {

    private Map<Integer, String> months;

    /**
     * Возвращает название месяца в виде строки (в виде "Я-Н-В-А-Р-Ь") по его порядковому номеру
     * @param request Объект-оболочка для номера месяца
     * @return Название месяца в виде строки
     */
    public MonthResponce getMonth(GetMonthRequest request) {
        if (request.getMonth() < 1 || request.getMonth() > 12) {
            return new MonthResponce("INCORRECT INPUT DATA");
        } else {
            return new MonthResponce(months.get(request.getMonth()));
        }
    }

    /**
     * Инициализация мапы "номер месяца - название месяца"
     */
    @PostConstruct
    private void init() {
        months = new HashMap<>();
        String[] monthsString = {"Я-Н-В-А-Р-Ь", "Ф-Е-В-Р-А-Л-Ь", "М-А-Р-Т", "А-П-Р-Е-Л-Ь",
                "М-А-Й", "И-Ю-Н-Ь", "И-Ю-Л-Ь", "А-В-Г-У-С-Т", "С-Е-Н-Т-Я-Б-Р-Ь", "О-К-Т-Я-Б-Р-Ь",
                "Н-О-Я-Б-Р-Ь", "Д-Е-К-А-Б-Р-Ь"};
        for (int i = 1; i < 13; i++) {
            months.put(i, monthsString[i - 1]);
        }
    }
}