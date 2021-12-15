package ru.samitin.calculator.model;

public class RepositoryImpl implements Repository {
    private String text="";
    @Override
    public String get() {
        return text;
    }

    @Override
    public void set(String text) {
        this.text=text;
    }
}
