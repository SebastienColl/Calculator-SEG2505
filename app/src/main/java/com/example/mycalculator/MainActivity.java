package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4,
           button5, button6, button7, button8, button9,
           buttonplus, buttonminus, buttondiv, buttontimes,
           buttonequals, buttondot, buttonclear, buttoninverse,
           buttonminusplus, buttonpercentage;
    TextView screen;
    float val1,val2;
    boolean add, minus, times, div, equals, inverse, minusplus, percentage;
    boolean operatorPressed = false, isResult = false, firstOperatorPressed = false;

    public void  memory(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        buttonplus = (Button) findViewById(R.id.btnplus);
        buttonminus = (Button) findViewById(R.id.btnminus);
        buttondiv = (Button) findViewById(R.id.btndiv);
        buttontimes = (Button) findViewById(R.id.btntimes);
        buttonequals = (Button) findViewById(R.id.btnequals);
        buttonclear = (Button) findViewById(R.id.btnclear);
        buttondot = (Button) findViewById(R.id.btndot);
        buttoninverse = (Button) findViewById(R.id.btninverse);
        buttonminusplus = (Button) findViewById(R.id.btnminusplus);
        buttonpercentage = (Button) findViewById(R.id.btnpercentage);

        screen = (TextView) findViewById(R.id.textprimary);
        screen.setText("0");

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText("0");
                add = false;
                minus = false;
                times = false;
                div = false;
                equals = false;
                isResult = false;
                inverse = false;
                minusplus = false;
                percentage = false;
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked(".");

            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("0");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("1");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("2");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("3");

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("4");

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("5");

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("6");

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("7");

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("8");

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                numberClicked("9");

            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                operatorClicked("add");

            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                operatorClicked("minus");

            }
        });
        buttontimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                operatorClicked("times");

            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                operatorClicked("div");
            }
        });
        buttoninverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                operatorClicked("inverse");
            }
        });
        buttonminusplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) { operatorClicked("minusplus");
            }
        });
        buttonpercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) { operatorClicked("percentage");
            }
        });
        buttonequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (add || minus || div || times || isResult || inverse || minusplus || percentage) {
                    equals = true;

                    if(operatorPressed){
                        val2 = val1 = Float.parseFloat(resetEdit());
                        operatorPressed = false;
                        resetButtonAppearance();
                    }
                    else if (isResult){
                        resetEdit();
                    }
                    else{
                        val2 = Float.parseFloat(resetEdit());
                    }

                    doOperation();

                    isResult = true;
                    firstOperatorPressed = false;
                }
            }
        });

    }

    private void doOperation(){
        float result = 0;

        if (add) {
            result = val1 + val2;
        }
        else if (minus) {
            result = val1 - val2;
        }
        else if (div) {
            result = val1 / val2;
        }
        else if (times) {
            result = val1 * val2;
        }
        else if (inverse) {
            result = 1/val2;
        }
        else if (minusplus) {
            result = val2 * -1;
        }
        else if (percentage) {
            result = val2 / 100;
        }

        val1 = result;

        if(result - (int)result != 0){
            addToEdit(String.valueOf(result));
        }
        else{
            addToEdit((String.valueOf((int)result)));
        }

        firstOperatorPressed = true;
    }

    private void addToEdit(String s){
        String initialValue = screen.getText().toString();

        if (initialValue != null && initialValue.trim().equals("0")){
            initialValue = "";
        }

        screen.setText(initialValue + s);
    }

    private String resetEdit(){
        String currentText = screen.getText().toString();
        screen.setText("0");

        return currentText;
    }

    private void numberClicked(String s){
        if (isResult){
            isResult = false;
            resetEdit();
        }
        else if (operatorPressed){
            String value = resetEdit();

            if (value != null && !value.trim().isEmpty()){
                val1 = Float.parseFloat(value);
            }

            operatorPressed = false;
            resetButtonAppearance();
        }

        addToEdit(s);
    }

    private void operatorClicked(String s){
        isResult = false;
        Button button = button0;

        if(screen == null) {
            screen.setText(null);
        }

        if (firstOperatorPressed && !operatorPressed){
            val2 = Float.parseFloat(resetEdit());
            doOperation();
        }
        else {
            firstOperatorPressed = true;
        }

        add = false;
        minus = false;
        div = false;
        times = false;
        inverse = false;
        minusplus = false;
        percentage = false;

        switch (s){
            case "add":
                add = true;
                button = buttonplus;
                break;
            case "minus":
                minus = true;
                button = buttonminus;
                break;
            case "div":
                div = true;
                button = buttondiv;
                break;
            case "times":
                button = buttontimes;
                times = true;
                break;
            case "inverse":
                button = buttoninverse;
                inverse = true;
                break;
            case "minusplus":
                button = buttonminusplus;
                minusplus = true;
                break;
            case "percentage":
                button = buttonpercentage;
                percentage = true;
                break;
        }

        if (operatorPressed){
            resetButtonAppearance();
        }

        if (button != button0) {
            button.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        }

        operatorPressed = true;
    }

    private void resetButtonAppearance(){
        Button[] operatorButtons =
                {buttondiv, buttonminus, buttontimes, buttonplus, buttonpercentage, buttoninverse, buttonminusplus};

        for (Button button: operatorButtons){
            button.getBackground().clearColorFilter();
        }
    }
}
