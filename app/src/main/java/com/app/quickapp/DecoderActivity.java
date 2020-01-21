package com.app.quickapp;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class DecoderActivity extends Activity implements QRCodeReaderView.OnQRCodeReadListener , View.OnClickListener {
    private boolean torch= false;
    private TextView resultTextView;
    private QRCodeReaderView qrCodeReaderView;
    private ImageView close, flash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);
        qrCodeReaderView = findViewById(R.id.qrdecoderview);
        resultTextView = findViewById(R.id.resultTextView);
        close = findViewById(R.id.close);
        flash = findViewById(R.id.torch);
        close.setOnClickListener(this);
        flash.setOnClickListener(this);
        qrCodeReaderView.setOnQRCodeReadListener(this);
        qrCodeReaderView.setQRDecodingEnabled(true);
        if (getPackageManager() != null){
            if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
                flash.setVisibility(View.VISIBLE);
            if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS))
                qrCodeReaderView.setAutofocusInterval(2000L);
        }
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        //resultTextView.setText(text);
        if (!text.isEmpty()){
            Intent i = new Intent(DecoderActivity.this, ResultActivity.class);
            i.putExtra("id", text);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                onBackPressed();
                break;
            case R.id.torch:
                try{
                    if (!torch){
                        qrCodeReaderView.setTorchEnabled(true);
                        torch = true;
                        flash.setImageResource(R.drawable.ic_flash_off_black_24dp);
                    }else{
                        qrCodeReaderView.setTorchEnabled(false);
                        torch = false;
                        flash.setImageResource(R.drawable.ic_flash_on_black_24dp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}
