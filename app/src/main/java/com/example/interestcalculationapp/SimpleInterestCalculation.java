package com.example.interestcalculationapp;

import android.util.Log;

public class SimpleInterestCalculation implements InterestCalculationInterface {
    @Override
    public double calculateInterest(long amount, double years, double rate) {
        Log.d("Amount", String.valueOf(amount));
        Log.d("Years", String.valueOf(years));
        Log.d("Rate Of Interest", String.valueOf(rate));
        double simpleInterest = 0;
        try {
            simpleInterest = (amount * years * rate) / 100;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        Log.d("Simple Interest", String.valueOf(simpleInterest));
        return simpleInterest;
    }
}
