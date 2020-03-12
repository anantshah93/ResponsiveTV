package com.anant.responsiveapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
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

        Log.e(TAG, "getDensity:"+getDensity(this));
        Log.e(TAG, "getDensityName:"+getDensityName(this));
    }
    private static String getDensityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }
    public static String getDensity(Context context) {
        String r;
        DisplayMetrics metrics = new DisplayMetrics();

        if (!(context instanceof Activity)) {
            r = "no-dpi";
        } else {
            Activity activity = (Activity) context;
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

            if (metrics.densityDpi <= DisplayMetrics.DENSITY_LOW) {
                r = "ldpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_MEDIUM) {
                r = "mdpi";
            }else if (metrics.densityDpi <= DisplayMetrics.DENSITY_HIGH) {
                r = "hdpi";
            }else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XHIGH) {
                r = "xhdpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XXHIGH) {
                r = "xxhdpi";
            }else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XXXHIGH) {
                r = "xxxhdpi";
            } else {
                r = "no-dpi";
            }
        }

        return r;
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
