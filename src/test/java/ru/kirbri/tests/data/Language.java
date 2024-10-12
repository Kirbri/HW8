package ru.kirbri.tests.data;

public enum Language {
    RU("Что такое Selenide?"), EN("What is Selenide?");
    private final String description;

    Language(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
