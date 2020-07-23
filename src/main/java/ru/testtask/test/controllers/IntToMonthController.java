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

    @GetMapping("/getMonth")
    public String getMonth (@Valid GetMonthRequest monthNumber, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return serviceIntToMonth.getMonth(monthNumber);
        } else {
           return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }

    }

}
