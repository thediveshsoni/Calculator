package com.example.diveshsoni.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
//    Button b0;
    private TextView eT;
    private String display ="";
    private String currentOperator = "";
    private Double result;
    private boolean checkOperator = false;
    private String[] operation;
    private TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //      b0 = (Button) findViewById(R.id.b0);
//        Button b1 = findViewById(R.id.b1);
//        Button b2 = findViewById(R.id.b2);
//        Button b3 = findViewById(R.id.b3);
//        Button b4 = findViewById(R.id.b4);
//        Button b5 = findViewById(R.id.b5);
//        Button b6 = findViewById(R.id.b6);
//        Button b7 = findViewById(R.id.b7);
//        Button b8 = findViewById(R.id.b8);
//        Button b9 = findViewById(R.id.b9);
//        Button badd = findViewById(R.id.badd);
//        Button bsub = findViewById(R.id.bsub);
//        Button bmultiply = findViewById(R.id.bmultiply);
//        Button bdivide = findViewById(R.id.bdivide);
//        Button bremainder = findViewById(R.id.brem);
//        Button bdel = findViewById(R.id.bdel);
//        Button bC = findViewById(R.id.bC);
//        Button bas = findViewById(R.id.bas);
//        Button bdot = findViewById(R.id.bdot);
//        Button bequal = findViewById(R.id.bequal);
          eT = findViewById(R.id.eT);
          eT.setText(display);
          tV = findViewById(R.id.tV);
    }

    private void updateScreen(){
        eT.setText(display);
    }

    public void onClickNumber(View v) {
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }

    public void onClickOperator(View v){
        Button b = (Button) v;
        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
        checkOperator = true;
    }

    private void clear(){
        display = "";
        currentOperator = "";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+":
                return Double.valueOf(a)+Double.valueOf(b);
            case "-":
                return Double.valueOf(a)-Double.valueOf(b);
            case "x":
                return Double.valueOf(a)*Double.valueOf(b);
            case "/":
                return Double.valueOf(a)/Double.valueOf(b);
            case "%":
                return Double.valueOf(a)%Double.valueOf(b);
            default:
                return -1;
        }
    }

    private Double calculateResult(){
        operation = display.split(Pattern.quote(currentOperator));
        result = operate(operation[0], operation[1], currentOperator);
        return result;
    }

    public void updateTextView(){
        tV.setText(display);
    }

    public void onClickEqual(View v){
        updateTextView();
        display = calculateResult().toString();
        updateScreen();
        display = result.toString();
        checkOperator = false;
    }
}
