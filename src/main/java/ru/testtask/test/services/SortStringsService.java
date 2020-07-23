package ru.testtask.test.services;

import org.springframework.stereotype.Service;
import ru.testtask.test.model.ProcessStringsRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SortStringsService {



    public String[] sortStrings (ProcessStringsRequest request) {
        List<String> listStrings = new ArrayList<>();

        for (String s : request.getStrings()) {
            listStrings.add("(" + s.length() + "): " + s);
        }

        Collections.sort(listStrings);

        return listStrings.toArray(new String[0]);
    }



}
