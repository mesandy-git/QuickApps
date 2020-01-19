package com.app.quickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;


public class ReaderActivity extends AppCompatActivity {
    private ImageView QRScannerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QRScannerBtn = findViewById(R.id.QrImage);
        QRScannerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReaderActivity.this, ScannerActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}



