package ru.testtask.test.model;

import org.hibernate.validator.constraints.Range;

public class GetMonthRequest {

    /**
     * Поле номер месяца
     */
    @Range(min = 1, max = 12, message = "INCORRECT INPUT DATA")
    private int month;

    /**
     * Геттер для номера месяца из запроса
     * @return Номер месяца
     */
    public int getMonth() {
        return month;
    }

    /**
     * Сеттер для номера месяца из запроса
     * @param month Номер месяца
     */
    public void setMonth(int month) {
        this.month = month;
    }
}
