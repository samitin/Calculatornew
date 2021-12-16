package ru.samitin.calculator.presenter;

import android.os.Bundle;

import ru.samitin.calculator.model.Repository;
import ru.samitin.calculator.view.View;

public class PresenterImpl implements Presenter{
    private static final String REPOSITORY_KEY="REPOSITORY_KEY";
    private static final String NUMBER_TEXT_KEY="NUMBER_TEXT";
    private static final String STATE_MATH_KEY="STATE_MATH_KEY";
    private View view;
    private Repository repository;
    private String numberText="";
    private String stateMath=ButtonsKeybosrd.NOT;
    public PresenterImpl(View view,Repository repository){
        this.view=view;
        this.repository=repository;
    }

    @Override
    public void clickNumber(int num) {
        numberText+=num;
        view.showText(numberText);
    }

    @Override
    public void clickMeaning(String meaning) {
        switch (meaning){
            case ButtonsKeybosrd.CLEAR:
            case ButtonsKeybosrd.DELITE:
            case ButtonsKeybosrd.PLUS_MINUS:
            case ButtonsKeybosrd.POINT:
                inputNumber(meaning);
                break;
            case ButtonsKeybosrd.PROCENT:
            case ButtonsKeybosrd.PLUS:
            case ButtonsKeybosrd.MINUS:
            case ButtonsKeybosrd.MULTIPLY:
            case ButtonsKeybosrd.DIVISION:
                if (numberText.length()>0)
                    math(meaning);
                break;
            case ButtonsKeybosrd.EQUALS:
                if (numberText.length()>0)
                    equals();
                break;
        }
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelable(REPOSITORY_KEY,repository);
        bundle.putString(NUMBER_TEXT_KEY, numberText);
        bundle.putString(STATE_MATH_KEY,stateMath);
    }

    @Override
    public void getState(Bundle bundle) {
        repository=bundle.getParcelable(REPOSITORY_KEY);
        numberText=bundle.getString(NUMBER_TEXT_KEY);
        stateMath=bundle.getString(STATE_MATH_KEY);
    }

    private void inputNumber(String meaning){
        switch (meaning) {
            case ButtonsKeybosrd.CLEAR:
                numberText = "";
                view.showText(numberText);repository.clear();
                break;
            case ButtonsKeybosrd.DELITE:
                if (numberText.length() > 0)
                    numberText = numberText.substring(0, numberText.length() - 1);
                view.showText(numberText);
                break;
            case ButtonsKeybosrd.PLUS_MINUS:
                if (numberText.contains("-"))
                    numberText = numberText.replace("-", "");
                else
                    numberText = "-" + numberText;
                view.showText(numberText);
                break;
            case ButtonsKeybosrd.POINT:
                if (!numberText.contains("."))
                    numberText = numberText + ".";
                view.showText(numberText);
                break;
        }
    }

    private void math(String meaning){
        if (repository.isNaN()){
            repository.setNumber(Double.parseDouble(numberText));
            stateMath=meaning;
            numberText="";
            view.showText(stateMath);
        }else {
            switch (stateMath) {
                case ButtonsKeybosrd.PROCENT:
                    repository.procent(Double.parseDouble(numberText));

                    break;
                case ButtonsKeybosrd.PLUS:
                    repository.plus(Double.parseDouble(numberText));

                    break;
                case ButtonsKeybosrd.MINUS:
                    repository.minus(Double.parseDouble(numberText));

                    break;
                case ButtonsKeybosrd.MULTIPLY:
                    repository.multiply(Double.parseDouble(numberText));

                    break;
                case ButtonsKeybosrd.DIVISION:
                    repository.division(Double.parseDouble(numberText));

                    break;
            }
            numberText="";
            stateMath=meaning;
            view.showText(stateMath);
        }

    }
    private void equals(){
        switch (stateMath) {
            case ButtonsKeybosrd.PROCENT:
                numberText=repository.procent(Double.parseDouble(numberText)).toString();
                break;
            case ButtonsKeybosrd.PLUS:
                numberText=repository.plus(Double.parseDouble(numberText)).toString();
                break;
            case ButtonsKeybosrd.MINUS:
                numberText=repository.minus(Double.parseDouble(numberText)).toString();
                break;
            case ButtonsKeybosrd.MULTIPLY:
                numberText=repository.multiply(Double.parseDouble(numberText)).toString();
                break;
            case ButtonsKeybosrd.DIVISION:
                numberText=repository.division(Double.parseDouble(numberText)).toString();
                break;
        }
        while (numberText.charAt(numberText.length()-1)=='0'||numberText.charAt(numberText.length()-1)=='.')
            numberText=numberText.replace(numberText.substring(numberText.length()-1),"");
        view.showText(numberText);
        stateMath=ButtonsKeybosrd.NOT;
    }

}
