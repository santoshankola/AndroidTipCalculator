package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {
    public EditText etTipAmount;
    public TextView tvTipAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etTipAmount = (EditText) findViewById(R.id.etTipAmount);
        tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
        
    }

    private String getDiscountedAmount(int percent, String amount){
    	double tipAmt=0.0, discountedAmt = 0.0;
    	try{
    	 tipAmt = Double.parseDouble(amount);
    	}
    	catch(Exception e){  		
    	}   	
    	discountedAmt = (tipAmt * percent)/100.00;	
    	String strDiscountedAmt = String.format("%1.2f", discountedAmt);
    	
    	return "$"+ strDiscountedAmt;
    }
    public void onBtn10Click(View v){
       	tvTipAmount.setText(getDiscountedAmount(10,etTipAmount.getText().toString()));
    }
    
    public void onBtn15Click(View v){
    	tvTipAmount.setText(getDiscountedAmount(15,etTipAmount.getText().toString()));
    }
    
    public void onBtn20Click(View v){
    	tvTipAmount.setText(getDiscountedAmount(20,etTipAmount.getText().toString()));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
    public void showSoftKeyboard(View view){
        if(view.requestFocus()){
            InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
    
    public void hideSoftKeyboard(View view){
    	  InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    	  imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    	}
    
}
