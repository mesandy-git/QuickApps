package com.app.quickapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView QRScannerBtn, send;
    private EditText id;
    private static final int REQUEST_CAMERA = 0, Result_Code= 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QRScannerBtn = findViewById(R.id.QrImage);
        send = findViewById(R.id.send);
        id = findViewById(R.id.id);
        QRScannerBtn.setOnClickListener(this);
        send.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.QrImage:
               if(getPermission())
               {
                   startActivityForResult(new Intent(HomeActivity.this, DecoderActivity.class),Result_Code);
               }
               break;
            case R.id.send:
                if (id.getText().toString().isEmpty()){
                    Snackbar.make(v, "Enter ID", Snackbar.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(HomeActivity.this, ResultActivity.class);
                    i.putExtra("id", id.getText().toString());
                    startActivity(i);
                }
                break;
        }
    }
    private  boolean getPermission(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(HomeActivity.this, Manifest.permission.CAMERA))
            {
                ActivityCompat.requestPermissions( HomeActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions( HomeActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            }
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA) {
            Log.i("Log", "Received response for Camera permission request.");
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(new Intent(HomeActivity.this, DecoderActivity.class),Result_Code);
                Log.i("Log", "CAMERA permission has now been granted. Showing preview.");
            } else {
                Log.i("Log", "CAMERA permission was NOT granted.");
            }
        }
        else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Result_Code ){

            if ( resultCode == Activity.RESULT_OK && data != null && data.hasExtra("id"))
            {
                Intent i = new Intent(HomeActivity.this, ResultActivity.class);
                i.putExtra("id", data.getStringExtra("id"));
                startActivity(i);
            }
        }else
            super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}



