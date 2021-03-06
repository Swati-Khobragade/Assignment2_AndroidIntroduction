package com.example.interestcalculationapp;

import android.util.Log;

public class CompoundInterestCalculation implements InterestCalculationInterface {
    @Override
    public double calculateInterest(long amount, double years, double rate) {
        Log.d("Amount", String.valueOf(amount));
        Log.d("Years", String.valueOf(years));
        Log.d("Rate Of Interest", String.valueOf(rate));
        double compoundInterest = 0;
        try {
            compoundInterest = amount *
                    (Math.pow((1 + rate / 100), years));
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        Log.d("Compound Interest", String.valueOf(compoundInterest));
        return compoundInterest;
    }
}
