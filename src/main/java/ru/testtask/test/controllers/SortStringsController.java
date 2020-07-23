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

    @PostMapping("/sortStrings")
    public String[] sortStrings (@RequestBody ProcessStringsRequest request) {
        return serviceSortStrings.sortStrings(request);

    }
}
