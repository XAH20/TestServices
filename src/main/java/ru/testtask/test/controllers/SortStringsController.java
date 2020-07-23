package ru.testtask.test.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.testtask.test.model.ProcessStringsRequest;
import ru.testtask.test.services.SortStringsService;

@RestController
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
     * @return Отсортированные строки
     */
    @PostMapping("/sortStrings")
    public String[] sortStrings (@RequestBody ProcessStringsRequest request) {
        return serviceSortStrings.sortStrings(request);

    }
}
