package com.anant.responsiveapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnActivity1;
    AppCompatButton btnActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity1.setOnClickListener(this);
        btnActivity2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnActivity2:
                intent = new Intent();
                intent.setClass(this, DemoActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnActivity1:
                intent = new Intent();
                intent.putExtra("INTENT_EXTRA_SSID", "AndroidTestWifi");
                intent.setClass(this, DemoActivity1.class);
                startActivity(intent);
                break;
        }
    }
}
