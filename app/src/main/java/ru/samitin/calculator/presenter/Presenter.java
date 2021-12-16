package ru.samitin.calculator.presenter;

import android.os.Bundle;

public interface Presenter {
    void clickNumber(int num);
    void clickMeaning(String meaning);
    void saveState(Bundle bundle);
    void getState(Bundle bundle);
}
