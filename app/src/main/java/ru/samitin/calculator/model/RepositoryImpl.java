package ru.samitin.calculator.model;

public class RepositoryImpl implements Repository {
    private Double number=Double.NaN;
    @Override
    public Double getNumber() {
        return number;
    }

    @Override
    public void setNumber(Double numder) {
        this.number=numder;
    }

    @Override
    public Double procent(Double num) {
        number=number%num;
        return number;
    }

    @Override
    public Double plus(Double num) {
        number=number+num;
        return number;
    }

    @Override
    public Double minus(Double num) {
        number=number-num;
        return number;
    }

    @Override
    public Double multiply(Double num) {
        number=number*num;
        return number;
    }

    @Override
    public Double division(Double num) {
        number=number/num;
        return number;
    }

    @Override
    public void clear() {
        number=Double.NaN;
    }

    @Override
    public boolean isNaN() {
        return number.equals(Double.NaN) ;
    }

}
