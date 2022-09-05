package com.krealif.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    EditText firstNumInput, secondNumInput;
    Button additionBtn, subtractionBtn, multiplicationBtn, divisionBtn;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        firstNumInput = findViewById(R.id.first_num);
        secondNumInput = findViewById(R.id.second_num);
        additionBtn = findViewById(R.id.addition_btn);
        subtractionBtn = findViewById(R.id.subtraction_btn);
        multiplicationBtn = findViewById(R.id.multiplication_btn);
        divisionBtn = findViewById(R.id.division_btn);
        resultTextView = findViewById(R.id.result_text);

        additionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("addition");
            }
        });

        subtractionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("subtraction");
            }
        });

        multiplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("multiplication");
            }
        });

        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("division");
            }
        });
    }


    private void calc(String operator) {
        String num1, num2;
        double result;
        num1 = firstNumInput.getText().toString();
        num2 = secondNumInput.getText().toString();
        if (!TextUtils.isEmpty(num1)) {
            if (!TextUtils.isEmpty(num2)) {
                result = countResult(num1, num2, operator);
                resultTextView.setText(String.valueOf(result));
            } else {
                secondNumInput.setError("This field cannot be left empty");
                resultTextView.setText("");
            }
        } else {
            firstNumInput.setError("This field cannot be left empty");
            resultTextView.setText("");
        }
    }

    private double countResult(String n1, String n2, String operator) {
        double num1, num2;
        num1 = Double.parseDouble(n1);
        num2 = Double.parseDouble(n2);

        switch (operator) {
            case "addition": return num1+num2;
            case "subtraction": return num1-num2;
            case "multiplication": return num1*num2;
            case "division": return num1/num2;
            default: return 0;
        }
    }
}