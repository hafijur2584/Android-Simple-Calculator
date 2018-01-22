package com.example.hafijur.calculatorhafijur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnminus,btnslash,btnc,btnstar,btnequal,btndot,btn0;
    TextView tvin,tvout;
    private Double val1 = Double.NaN;
    private Double val2;
    private char ACT;
    private final char ADDIITION = '+';
    private final char SUBBTRACTION = '-';
    private final char MULTICLICATION = '*';
    private final char DIVITION = '/';
    private final char EQU = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allinitialization();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvin.setText(tvin.getText().toString()+'2');
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+"0");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                ACT = ADDIITION;
                tvout.setText(tvin.getText().toString()+'+');
                tvin.setText(null);
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                ACT = SUBBTRACTION;
                tvout.setText(tvin.getText().toString()+'-');
                tvin.setText(null);

            }
        });
        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                ACT = MULTICLICATION;
                tvout.setText(tvin.getText().toString()+'*');
                tvin.setText(null);
            }
        });

        btnslash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                ACT = DIVITION;
                tvout.setText(tvin.getText().toString()+'/');
                tvin.setText(null);
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                ACT = EQU;

                 /* This change for calculate val1 and val2...
                 *
                  * Name : Md. Hafijur Rahman
                  * Id: 151-15-219
                  * Section: PC-A
                  *
                  * */

                tvout.setText(tvout.getText().toString() + String.valueOf(val2) + '=' + String.valueOf(val1));
                tvin.setText(null);
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvin.setText(tvin.getText().toString()+".");
            }
        });


        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* This change for clear both text field...
                 *
                  * Name : Md. Hafijur Rahman
                  * Id: 151-15-219
                  * Section: PC-A
                  *
                  * */

                if (tvin.getText().length() > 0){
                    /*
                    * This change for empty of value val1
                    *
                    *
                    *
                    * Name: Hafijur Rahman
                    * Id: 151-15-219
                    * Section : PC-A
                    *
                    * */

                    CharSequence name = tvin.getText().toString();
                    tvin.setText(name.subSequence(0, name.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    tvin.setText(null);
                    tvout.setText(null);
                }
            }
        });


    }



    public void allinitialization(){
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        btnplus = (Button)findViewById(R.id.btnplus);
        btnminus = (Button)findViewById(R.id.btnminus);
        btnstar = (Button)findViewById(R.id.btnstar);
        btnslash = (Button)findViewById(R.id.btnslash);
        btnc = (Button)findViewById(R.id.btnc);
        btnequal = (Button)findViewById(R.id.btnequal);
        btndot = (Button)findViewById(R.id.btndot);
        tvin = (TextView) findViewById(R.id.tvin);
        tvout = (TextView) findViewById(R.id.tvout);
    }

    public void calculation(){
        if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(tvin.getText().toString());

            switch (ACT){
                case ADDIITION:
                    val1 = val1 + val2;
                    break;
                case SUBBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTICLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVITION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }

        }else {
            val1 = Double.parseDouble(tvin.getText().toString());
        }


    }


}



