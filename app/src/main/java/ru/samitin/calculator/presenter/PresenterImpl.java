package ru.samitin.calculator.presenter;

import ru.samitin.calculator.model.Repository;
import ru.samitin.calculator.view.View;

public class PresenterImpl implements Presenter{
    private View view;
    private Repository repository;
    public PresenterImpl(View view,Repository repository){
        this.view=view;
        this.repository=repository;
    }
    @Override
    public void clickNumber(int num) {
        view.showText(Integer.toString(num));
    }

    @Override
    public void clickMeaning(ButtonsKeybosrd meaning) {

    }
}
