package com.tony.mojcalc;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.dot);

        Button buttonDivide = findViewById(R.id.divide);
        Button buttonEqual = findViewById(R.id.equal);
        Button buttonMinus = findViewById(R.id.minus);
        Button buttonPlus = findViewById(R.id.plus);
        Button buttonMultiple = findViewById(R.id.multiple);
        final Button buttonclear = findViewById(R.id.buttonclear);


        View.OnClickListener numbers = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;

                String currentResult = result.getText().toString();
                String nowClicked = b.getText().toString();
                String empty = "";


                if (!((currentResult.endsWith("x") ||currentResult.endsWith(".") || currentResult.endsWith("/") || currentResult.endsWith("+") || currentResult.endsWith("-")) && (nowClicked.equals("/") ||
                        nowClicked.equals("+") || nowClicked.equals("-") || nowClicked.equals(".")|| nowClicked.equals("x")))) {
                    result.append(nowClicked);
                }

            }
        };
        button0.setOnClickListener(numbers);
        button1.setOnClickListener(numbers);
        button2.setOnClickListener(numbers);
        button3.setOnClickListener(numbers);
        button4.setOnClickListener(numbers);
        button5.setOnClickListener(numbers);
        button6.setOnClickListener(numbers);
        button7.setOnClickListener(numbers);
        button8.setOnClickListener(numbers);
        button9.setOnClickListener(numbers);
        buttonDot.setOnClickListener(numbers);


        buttonDivide.setOnClickListener(numbers);
        buttonMultiple.setOnClickListener(numbers);
        buttonMinus.setOnClickListener(numbers);
        buttonPlus.setOnClickListener(numbers);
        View.OnClickListener equal = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] successfullSplitedArray;
                successfullSplitedArray = result.getText().toString().split("x");
                if (successfullSplitedArray.length > 1) {
                    Double firstVariable1 = Double.parseDouble(successfullSplitedArray[0]);
                    Double secondVariable1 = Double.parseDouble(successfullSplitedArray[1]);
                    result.setText("" + firstVariable1 * secondVariable1);

                    return;
                }
                successfullSplitedArray = result.getText().toString().split("\\-");
                if (successfullSplitedArray.length > 1) {
                    Double firstVariable1 = Double.parseDouble(successfullSplitedArray[0]);
                    Double secondVariable1 = Double.parseDouble(successfullSplitedArray[1]);
                    result.setText("" + (firstVariable1 - secondVariable1));
                    return;
                }
                successfullSplitedArray = result.getText().toString().split("\\+");
                if (successfullSplitedArray.length > 1) {
                    Double firstVariable1 = Double.parseDouble(successfullSplitedArray[0]);
                    Double secondVariable1 = Double.parseDouble(successfullSplitedArray[1]);
                    result.setText("" + (firstVariable1 + secondVariable1));
                    return;
                }
                successfullSplitedArray = result.getText().toString().split("\\/");
                if (successfullSplitedArray.length > 1) {
                    Double firstVariable1 = Double.parseDouble(successfullSplitedArray[0]);
                    Double secondVariable1 = Double.parseDouble(successfullSplitedArray[1]);
                    result.setText("" + (firstVariable1 / secondVariable1));
                    return;
                }

            }
        };
        buttonEqual.setOnClickListener(equal);
        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Button b = (Button) v;
            if(b.getText().toString().equals("C")){
                result.setText("");
            }
            }
        };
        buttonclear.setOnClickListener(clear);
    }
}

