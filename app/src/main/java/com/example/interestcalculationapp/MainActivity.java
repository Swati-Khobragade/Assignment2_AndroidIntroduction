package com.example.interestcalculationapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextAmount = (EditText) findViewById(R.id.etAmount);
        final EditText editTextNoOfYrs = (EditText) findViewById(R.id.etNoOfYears);
        final EditText editTextRateOfInt = (EditText) findViewById(R.id.etRateOfInt);
        final EditText editTextCalcInt = (EditText) findViewById(R.id.etCalculatedInterest);
        Button buttonCalcSimpleInterest = (Button) findViewById(R.id.btnSimpleInterest);
        Button buttonCalcCompInterest = (Button) findViewById(R.id.btnCompInterest);

        editTextCalcInt.setEnabled(false);
        editTextCalcInt.setTextColor(Color.BLACK);

        buttonCalcSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editTextAmount.getText().toString().trim();
                String years = editTextNoOfYrs.getText().toString().trim();
                String rate = editTextRateOfInt.getText().toString().trim();
                if (validateFields(amount, years, rate)) {
                    SimpleInterestCalculation simpleInterestCalculation = new SimpleInterestCalculation();
                    Double interestValue = simpleInterestCalculation.calculateInterest(Long.parseLong(amount), Double.parseDouble(years), Double.parseDouble(rate));
                    editTextCalcInt.setText(interestValue.toString());
                }
            }
        });
        buttonCalcCompInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editTextAmount.getText().toString().trim();
                String years = editTextNoOfYrs.getText().toString().trim();
                String rate = editTextRateOfInt.getText().toString().trim();
                if (validateFields(amount, years, rate)) {
                    CompoundInterestCalculation compoundInterestCalculation = new CompoundInterestCalculation();
                    Double interestValue = compoundInterestCalculation.calculateInterest(Long.parseLong(editTextAmount.getText().toString().trim()), Double.parseDouble(editTextNoOfYrs.getText().toString().trim()), Double.parseDouble(editTextRateOfInt.getText().toString().trim()));
                    editTextCalcInt.setText(interestValue.toString());
                }
            }
        });

    }

    private boolean validateFields(String amount, String years, String rate) {
        if (TextUtils.isEmpty(amount)) {
            Toast.makeText(getApplicationContext(), "Please Enter Amount", LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(years)) {
            Toast.makeText(getApplicationContext(), "Please Enter No. Of Years", LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(rate)) {
            Toast.makeText(getApplicationContext(), "Please Enter Rate Of Interest", LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
