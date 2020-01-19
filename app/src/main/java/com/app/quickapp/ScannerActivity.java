package com.app.quickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class ScannerActivity extends AppCompatActivity {
    private SurfaceView surfaceView ;
    private TextView textView ;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    final int RequestCameraPermissionID=1;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){

            case RequestCameraPermissionID:
            {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    try {
                        cameraSource.start(surfaceView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scannner);
        getSupportActionBar().hide();
        surfaceView = findViewById(R.id.surface);
        textView = findViewById(R.id.txtView);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource =new CameraSource
                .Builder(this, barcodeDetector)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {   ActivityCompat.requestPermissions(ScannerActivity.this, new String[] {Manifest.permission.CAMERA }, RequestCameraPermissionID);

                    return;}
                try {
                    cameraSource.start(surfaceView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCode =  detections.getDetectedItems();
                if (qrCode.size() !=0 ){
                    Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(1000);
                    Intent intent = new Intent(ScannerActivity.this, ResultActivity.class);
                    intent.putExtra("id",qrCode.valueAt(0).rawValue );
                    startActivity(intent);
                    cameraSource.release();
                    cameraSource.stop();
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        cameraSource.release();
        cameraSource.stop();
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        cameraSource.release();
        cameraSource.stop();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cameraSource.release();
        cameraSource.stop();
        startActivity(new Intent(ScannerActivity.this, ReaderActivity.class));
    }
}
