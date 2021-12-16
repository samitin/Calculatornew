package ru.samitin.calculator.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.samitin.calculator.R;
import ru.samitin.calculator.model.RepositoryImpl;
import ru.samitin.calculator.presenter.ButtonsKeybosrd;
import ru.samitin.calculator.presenter.Presenter;
import ru.samitin.calculator.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements View {
    private Presenter presenter;
    int[]numberIds;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter= new PresenterImpl(this,new RepositoryImpl());

        numberIds = new int[]{
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6,
                R.id.button_7, R.id.button_8, R.id.button_9};
        for (int numberId : numberIds) findViewById(numberId).setOnClickListener(numbersListener);

        int[]meaningIds={R.id.button_clear,R.id.button_dellite,R.id.button_plus_minus,R.id.button_procent,
                R.id.button_plus,R.id.button_minus,R.id.button_multiply,R.id.button_division,R.id.button_point,R.id.button_equals};
        for (int id:meaningIds)
            findViewById(id).setOnClickListener(meaningsListener);

    }
    private final android.view.View.OnClickListener numbersListener=new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View view) {
            for (int i=0;i<numberIds.length; i++)
                if (view.getId() == numberIds[i])
                    presenter.clickNumber(i);
        }
    };

    private final android.view.View.OnClickListener meaningsListener=new android.view.View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(android.view.View view) {
           switch (view.getId()){
               case R.id.button_clear:
                   presenter.clickMeaning(ButtonsKeybosrd.CLEAR);
                   break;
               case R.id.button_dellite:
                   presenter.clickMeaning(ButtonsKeybosrd.DELITE);
                   break;
               case R.id.button_plus_minus:
                   presenter.clickMeaning(ButtonsKeybosrd.PLUS_MINUS);
                   break;
               case R.id.button_procent:
                   presenter.clickMeaning(ButtonsKeybosrd.PROCENT);
                   break;
               case R.id.button_plus:
                   presenter.clickMeaning(ButtonsKeybosrd.PLUS);
                   break;
               case R.id.button_minus:
                   presenter.clickMeaning(ButtonsKeybosrd.MINUS);
                   break;
               case R.id.button_multiply:
                   presenter.clickMeaning(ButtonsKeybosrd.MULTIPLY);
                   break;
               case R.id.button_division:
                   presenter.clickMeaning(ButtonsKeybosrd.DIVISION);
                   break;
               case R.id.button_point:
                   presenter.clickMeaning(ButtonsKeybosrd.POINT);
                   break;
               case R.id.button_equals:
                   presenter.clickMeaning(ButtonsKeybosrd.EQUALS);
                   break;
           }
        }
    };

    @Override
    public void showText(String text) {
        EditText etText=findViewById(R.id.editTextNumber);
        etText.setText(text);
    }
}
