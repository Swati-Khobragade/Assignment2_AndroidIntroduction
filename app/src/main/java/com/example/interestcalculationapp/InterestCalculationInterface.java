package com.example.interestcalculationapp;


import android.util.Log;
import android.widget.EditText;

import java.util.logging.Logger;

public interface InterestCalculationInterface {
    double calculateInterest(long amount,double years,double rate);
//     void calculateInterest(long amount,double years,double rate){
//        //Log.d("amount", String.valueOf(amount));
//    }
}
