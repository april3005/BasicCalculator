package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multiplication, division, equals, clear, dot;
    TextView resultTV;
    String rawOperand = "";
    Double firstOperand;
    Double secondOperand;
    String operation;
    Double result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.btn_result);
        zero = findViewById(R.id.btn_zero);
        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        plus = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_minus);
        multiplication = findViewById(R.id.btn_multiplication);
        division = findViewById(R.id.btn_division);
        equals = findViewById(R.id.btn_equals);
        clear = findViewById(R.id.btn_clear);
        dot = findViewById(R.id.btn_dot);

        if (savedInstanceState != null){
            firstOperand = savedInstanceState.getDouble("first");
            secondOperand = savedInstanceState.getDouble("second");
            result = savedInstanceState.getDouble("result");
            rawOperand = savedInstanceState.getString("rawOperand");
            operation = savedInstanceState.getString("operation");

            String toShow = " " + firstOperand + " " + operation + " " + secondOperand + "=" + result;

            resultTV.setText(toShow);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("first", firstOperand);
        outState.putDouble("second", secondOperand);
        outState.putDouble("result", result);
        outState.putString("rawOperand", "");
        outState.putString("operation", operation);
    }

    public void onNumberClick(View v){
        switch (v.getId()){
            case R.id.btn_one:
            enterNumber("1");
            break;

            case R.id.btn_two:
                enterNumber("2");
                break;

            case R.id.btn_three:
                enterNumber("3");
                break;

            case R.id.btn_four:
                enterNumber("4");
                break;

            case R.id.btn_five:
                enterNumber("5");
                break;

            case R.id.btn_six:
                enterNumber("6");
                break;

            case R.id.btn_seven:
                enterNumber("7");
                break;

            case R.id.btn_eight:
                enterNumber("8");
                break;

            case R.id.btn_nine:
                enterNumber("9");
                break;

            case R.id.btn_dot:
                enterNumber(".");
                break;

            case R.id.btn_zero:
                enterNumber("0");
                break;
            default:
                break;

            case R.id.btn_clear:
                resultTV.setText(" ");
                break;

        }
    }

    public void enterNumber(String number){
        resultTV.append(number);
        rawOperand += number;
    }

    public void onOperationClick(View v) {
        try {if (firstOperand == null) {
            firstOperand = Double.parseDouble(rawOperand);

        } else {
            secondOperand = Double.parseDouble(rawOperand);
        }
            rawOperand = "";

        } catch(Exception error){
            error.printStackTrace();
        }

        switch (v.getId()) {
            case R.id.btn_plus:
                enterOperation("+");
                break;

            case R.id.btn_multiplication:
                enterOperation("*");
                break;

            case R.id.btn_minus:
                enterOperation("-");
                break;

            case R.id.btn_division:
                enterOperation("/");
                break;


            case R.id.btn_equals:
                if (operation != null) {
                    switch (operation) {
                        case "+":
                            result = firstOperand + secondOperand;
                            resultTV.append("=" + result);
                            break;

                        case "*":
                            result = firstOperand * secondOperand;
                            resultTV.append("=" + result);
                            break;

                        case "-":
                            result = firstOperand - secondOperand;
                            resultTV.append("=" + result);
                            break;

                        case "/":
                            result = firstOperand / secondOperand;
                            resultTV.append("=" + result);
                            break;
                    }
                }
            default:
                break;
        }


    }

    public void enterOperation(String operation){
        resultTV.append(operation);
        this.operation = operation;
    }
}
