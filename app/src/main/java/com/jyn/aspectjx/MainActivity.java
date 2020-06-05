package com.jyn.aspectjx;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jyn.aspectjx.permission.annotation.PermissionCheck;
import com.jyn.aspectjx.repeat.annotation.RepeatClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "MainActivity";
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @RepeatClick(interval = 3000)
    public void check(View view) {
        checkPermissions();
    }

    @PermissionCheck(permissions = Manifest.permission.WRITE_EXTERNAL_STORAGE, requestCode = 100)
    private void checkPermissions() {
        Log.i(TAG, "onTouch --->");
    }

    @Override
    public void onClick(View v) {

    }
}
