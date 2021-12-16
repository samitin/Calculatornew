package ru.samitin.calculator.model;

public interface Repository {
    Double getNumber();
    void setNumber(Double num);
    Double procent(Double num);
    Double plus(Double num);
    Double minus(Double num);
    Double multiply(Double num);
    Double division(Double num);
    void clear();
    boolean isNaN();
}
