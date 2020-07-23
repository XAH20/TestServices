package ru.testtask.test.model;

import org.hibernate.validator.constraints.Range;

public class GetMonthRequest {
    @Range(min = 1, max = 12, message = "INCORRECT INPUT DATA")

    /**
     * Поле номер месяца
     */
    private int month;

    /**
     * Геттер для номера месяца
     * @return Номер месяца
     */
    public int getMonth() {
        return month;
    }

}
