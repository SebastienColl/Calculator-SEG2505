package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

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
    boolean add, minus, times, div, equals;

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

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(null);
                add = false;
                minus = false;
                times = false;
                div = false;
                equals = false;

            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + ".");

            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "0");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "1");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "2");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "3");

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "4");

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "5");

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "6");

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "7");

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "8");

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                screen.setText(screen.getText() + "9");

            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if(screen == null) {
                    screen.setText(null);
                }

                val1 = Float.parseFloat(screen.getText() + " ");

                add = true;
                screen.setText(null);

            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if(screen == null) {
                    screen.setText(null);
                }

                val1 = Float.parseFloat(screen.getText() + " ");

                minus = true;
                screen.setText(null);

            }
        });
        buttontimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if(screen == null) {
                    screen.setText(null);
                }

                val1 = Float.parseFloat(screen.getText() + " ");

                times = true;
                screen.setText(null);

            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if(screen == null) {
                    screen.setText(null);
                }

                val1 = Float.parseFloat(screen.getText() + " ");

                div = true;
                screen.setText(null);

            }
        });
        buttonequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                equals = true;
                val2 = Float.parseFloat(screen.getText() + " ");

                if (add) {
                    screen.setText((val1 + val2) + " ");
                    add = false;
                }
                if (minus) {
                    screen.setText((val1 - val2) + " ");
                    minus = false;
                }
                if (div) {
                    screen.setText((val1/val2) + " ");
                    div = false;
                }
                if (times) {
                    screen.setText((val1*val2) + " ");
                    times = false;
                }

            }
        });

    }
}
