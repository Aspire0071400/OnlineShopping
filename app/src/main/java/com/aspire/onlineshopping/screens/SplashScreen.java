package com.aspire.onlineshopping.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.aspire.onlineshopping.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, LoginPage.class);
            startActivity(i);
            finish();
        },1000);

    }
}