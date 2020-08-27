package ru.testtask.test.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.testtask.test.model.ProcessStringsRequest;
import ru.testtask.test.model.StringsResponce;
import ru.testtask.test.services.SortStringsService;

@Controller
public class SortStringsController {
    private SortStringsService serviceSortStrings;

    public SortStringsController(SortStringsService serviceSortStrings) {
        this.serviceSortStrings = serviceSortStrings;
    }

    /**
     * Возвращает результат работы сервиса сортировки строки:
     * по количеству символов, при одинаковом количестве - лексикографически.
     * Преобразует строки в вид: "(кол-во символов): Строка"
     * @param request Объект-оболочка для строк
     * @return Объект-оболочка с ответом
     */
    @MessageMapping("/sortStrings")
    @SendTo("/topic/strings")
    public StringsResponce sortStrings (ProcessStringsRequest request) throws JsonProcessingException {
        return serviceSortStrings.sortStrings(request);
    }
}
