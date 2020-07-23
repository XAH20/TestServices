package ru.testtask.test.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testtask.test.model.GetMonthRequest;
import ru.testtask.test.services.IntToMonthService;

import javax.validation.Valid;

@RestController
public class IntToMonthController {
    private IntToMonthService serviceIntToMonth;

    public IntToMonthController(IntToMonthService serviceIntToMonth) {
        this.serviceIntToMonth = serviceIntToMonth;
    }

    /**
     * Возвращает результат работы сервиса для получения название месяца (в виде "Я-Н-В-А-Р-Ь")
     * по его порядковому номеру
     * @param monthNumber Объект-оболочка для номера месяца
     * @param bindingResult Объект с результатами валидации
     * @return Название месяца в виде строки
     */
    @GetMapping("/getMonth")
    public String getMonth (@Valid GetMonthRequest monthNumber, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        } else {
            return serviceIntToMonth.getMonth(monthNumber);
        }

    }

}
