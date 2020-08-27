package ru.testtask.test.model;

/**
 * Класс-оболочка с ответом на запрос
 */
public class MonthResponce {

    /**
     * Поле с ответом на запрос
     */
    private String content;

    public MonthResponce(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
