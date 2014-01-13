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
import android.widget.Toast;

public class TipCalculator extends Activity {
    public EditText etTotalAmount;
    public TextView tvTipAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
        tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
        
    }
    
    public void onTotalAmountClick(View v){
    	showSoftKeyboard(v);
    }

    private String getDiscountedAmount(int percent, String amount){
    	if(amount.equalsIgnoreCase("")){
    		Toast.makeText(getApplicationContext(), R.string.amount_empty, Toast.LENGTH_SHORT).show();
    		return "";
    	}
    	
    	double tipAmt=0.0, discountedAmt = 0.0; String strDiscountedAmt="";
    	try{
    	 tipAmt = Double.parseDouble(amount);
    	 if(tipAmt == 0.0 || tipAmt < 0.0){
     		Toast.makeText(getApplicationContext(), R.string.amount_zero, Toast.LENGTH_SHORT).show();
     		return "";
     	 }
     	 discountedAmt = (tipAmt * percent)/100.00;	
     	 strDiscountedAmt = String.format("%1.2f", discountedAmt);
    	}
    	catch(Exception e){ 
    		Toast.makeText(getApplicationContext(), R.string.amount_invalid, Toast.LENGTH_SHORT).show();
    		return "";
    	}   
    	
    	
    	return "$"+ strDiscountedAmt;
    }
    
    public void onBtnClick(View v){
    	String percentStr = v.getTag().toString();
    	int percentNum = Integer.parseInt(percentStr);
    	tvTipAmount.setText(getDiscountedAmount(percentNum,etTotalAmount.getText().toString()));
    	hideSoftKeyboard(v);
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
