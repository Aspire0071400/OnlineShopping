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
import com.aspire.onlineshopping.LandingPage;
import com.aspire.onlineshopping.R;
import com.aspire.onlineshopping.databaseModels.DataBaseHelper;
import com.aspire.onlineshopping.utils.User;
import com.google.android.material.textfield.TextInputLayout;

public class LoginPage extends AppCompatActivity {

    EditText edtEmailLogin,edtPassLogin;
    TextInputLayout tilEmailLog,tilPassLog;
    TextView tvNewUser;
    Button btnLogin;
    InputValidation inputValidation;
    DataBaseHelper db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPassLogin = findViewById(R.id.edtPassLogin);
        tvNewUser = findViewById(R.id.tvNewUser);
        btnLogin = findViewById(R.id.btnLogin);
        tilEmailLog = findViewById(R.id.tilEmailLog);
        tilPassLog = findViewById(R.id.tilPassLog);
        inputValidation = new InputValidation(LoginPage.this);
        db = new DataBaseHelper(this);

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginPage.this,RegisterPage.class);
                startActivity(i);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = edtEmailLogin.getText().toString().trim();
                String loginPass = edtPassLogin.getText().toString().trim();
                boolean check = db.checkPass(loginEmail,loginPass);

                if(!inputValidation.isInputEditTextFilled(edtEmailLogin, tilEmailLog,"Enter Name First!")){
                    return;
                }
                if(!inputValidation.isInputEditTextFilled(edtPassLogin,tilPassLog,"Enter Password First")){
                    return;
                }
                if(!inputValidation.isInputEditTextEmailFilled(edtEmailLogin,tilEmailLog,"Enter Correct Email")){
                    return;
                }
                if(check==true){
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginPage.this, LandingPage.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }
}