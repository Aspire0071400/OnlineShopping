package com.aspire.onlineshopping.utils;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.util.Patterns;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {
    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean isInputEditTextFilled( EditText textInputEditText, TextInputLayout textInputLayout, String message){
     String value = textInputEditText.getText().toString().trim();
     if(value.isEmpty()){
         textInputLayout.setError(message);
         return false;
     }else textInputLayout.setErrorEnabled(false);
     return true;
    }

    public boolean isInputEditTextEmailFilled(EditText textInputEditText,TextInputLayout textInputLayout,String message){
        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            textInputLayout.setError(message);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2, TextInputLayout textInputLayout,String message){
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if(!value1.contentEquals(value2)){
            textInputLayout.setError(message);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

}
