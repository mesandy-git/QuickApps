package com.app.quickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        int miliSec = 3000;
        new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 startActivity(new Intent(SplashScreen.this, HomeActivity.class ));
                 finish();
             }
         }, miliSec);
    }
}
