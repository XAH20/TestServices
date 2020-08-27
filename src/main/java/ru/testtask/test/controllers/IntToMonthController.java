package ru.testtask.test.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.testtask.test.model.GetMonthRequest;
import ru.testtask.test.model.MonthResponce;
import ru.testtask.test.services.IntToMonthService;

@Controller
public class IntToMonthController {
    private IntToMonthService serviceIntToMonth;

    public IntToMonthController(IntToMonthService serviceIntToMonth) {
        this.serviceIntToMonth = serviceIntToMonth;
    }

    /**
     * Возвращает результат работы сервиса для получения название месяца (в виде "Я-Н-В-А-Р-Ь")
     * по его порядковому номеру
     *
     * @param monthNumber Объект-оболочка для номера месяца
     * @return Название месяца в виде строки
     */
    @MessageMapping("/getMonth")
    @SendTo("/topic/month")
    public MonthResponce getMonth(GetMonthRequest monthNumber) {
        return serviceIntToMonth.getMonth(monthNumber);
    }
}
