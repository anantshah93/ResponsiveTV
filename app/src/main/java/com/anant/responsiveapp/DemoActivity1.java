package com.anant.responsiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.logitech.videocollaboration.froggeruilib.FroggerFocusButton;

public class DemoActivity1 extends AppCompatActivity implements View.OnClickListener {
    private String wifiSSID;
    private FroggerFocusButton mForgetButton, mCancelButton;
    private ImageButton mCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);

        wifiSSID = getIntent().getStringExtra("INTENT_EXTRA_SSID");
        initViews();

    }

    private void initViews () {
        ((TextView)findViewById(R.id.titleTextView)).setText(String.format(getString(R.string.disconnect_wifi_header), wifiSSID));
        mForgetButton = findViewById(R.id.forgetButton);
        mCancelButton = findViewById(R.id.cancelButton);
        mCloseBtn = findViewById(R.id.closeButton);

        mForgetButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
        mCloseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgetButton:
                finish();
                break;

            case R.id.cancelButton:
            case R.id.closeButton:
                finish();
                break;
        }
    }
}
