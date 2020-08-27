package ru.testtask.test.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import ru.testtask.test.model.ProcessStringsRequest;
import ru.testtask.test.model.StringsResponce;

import java.util.*;

@Service
public class SortStringsService {

    /**
     * Сортирует строки:
     * по количеству символов, при одинаковом количестве - лексикографически.
     * Преобразует строки в вид: "(кол-во символов): Строка"
     * @param request Объект-оболочка для запроса
     * @return Объект-оболочка с ответом (массив преобразованных и отсортироанных строк в формате JSON в виде строки)
     */
    public StringsResponce sortStrings (ProcessStringsRequest request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String[] strings = mapper.readValue(request.getStrings(), String[].class);

        List<String> listStrings = new ArrayList<>();
        for (String s : strings) {
            listStrings.add("(" + s.length() + "): " + s);
        }
        Collections.sort(listStrings);

        ObjectMapper mapperResponce = new ObjectMapper();
        mapperResponce.enable(SerializationFeature.INDENT_OUTPUT);
        String responseJson = mapperResponce.writeValueAsString(listStrings);


        return new StringsResponce(responseJson);


    }



}
