package ru.testtask.test.model;

import org.hibernate.validator.constraints.Range;

public class GetMonthRequest {
    @Range(min = 1, max = 12, message = "INCORRECT INPUT DATA")
    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
