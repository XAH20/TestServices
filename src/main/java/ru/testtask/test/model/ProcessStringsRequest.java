package ru.testtask.test.model;

public class ProcessStringsRequest {

    /**
     * Поле строки
     */
    private String[] strings;

    /**
     * Геттер для массива строк из запроса
     * @return массив строк
     */
    public String[] getStrings() {
        return strings;
    }

    /**
     * Сеттер для массива строк из запроса
     * @param strings Строки
     */
    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
