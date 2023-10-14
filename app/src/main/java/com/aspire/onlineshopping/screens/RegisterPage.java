package com.aspire.onlineshopping.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aspire.onlineshopping.utils.InputValidation;
import com.aspire.onlineshopping.R;
import com.aspire.onlineshopping.databaseModels.DataBaseHelper;
import com.aspire.onlineshopping.utils.User;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterPage extends AppCompatActivity {
    EditText edtNameReg,edtEmailReg,edtPassReg,edtConPassReg;
    TextInputLayout tilName,tilEmail,tilPass,tilConPass;
    Button btnRegister;
    TextView tvAlreadyRegister;

    InputValidation inputValidation;
    User user;
    DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        edtNameReg = findViewById(R.id.edtNameReg);
        edtEmailReg = findViewById(R.id.edtEmailReg);
        edtPassReg = findViewById(R.id.edtPassReg);
        edtConPassReg = findViewById(R.id.edtConPassReg);
        tilName = findViewById(R.id.tilName);
        tilEmail = findViewById(R.id.tilEmail);
        tilPass = findViewById(R.id.tilPass);
        tilConPass = findViewById(R.id.tilConPass);
        btnRegister = findViewById(R.id.btnRegister);
        tvAlreadyRegister = findViewById(R.id.tvAlreadyAccount);

        inputValidation = new InputValidation(RegisterPage.this);
        databaseHelper = new DataBaseHelper(RegisterPage.this);
        user = new User();


        tvAlreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputValidation.isInputEditTextFilled(edtNameReg,tilName,"Enter Full Name")){
                    return ;
                }
                if(!inputValidation.isInputEditTextFilled(edtEmailReg,tilEmail,"Enter Valid Email")){
                    return ;
                }
                if(!inputValidation.isInputEditTextEmailFilled(edtEmailReg,tilEmail,"Enter Valid Email")){
                    return ;
                }
                if(!inputValidation.isInputEditTextFilled(edtPassReg,tilPass,"Enter Password")){
                    return ;
                }
                if(!inputValidation.isInputEditTextMatches(edtPassReg,edtConPassReg,tilConPass,"Password Does not Match")){
                    return ;
                }
                if(!databaseHelper.checkUser(edtEmailReg.getText().toString().trim())) {
                    user.setName(edtNameReg.getText().toString().trim());
                    user.setEmail(edtEmailReg.getText().toString().trim());
                    user.setPassword(edtPassReg.getText().toString().trim());
                    databaseHelper.addUser(user);

                    Toast.makeText(RegisterPage.this,"Registration Successful",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(RegisterPage.this,LoginPage.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(RegisterPage.this, "Email Already Exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}