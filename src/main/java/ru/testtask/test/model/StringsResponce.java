package ru.testtask.test.model;

/**
 * Класс-оболочка с ответом на запрос
 */
public class StringsResponce {

    /**
     * Поле с ответом на запрос
     */
    private String content;

    public StringsResponce(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
