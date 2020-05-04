package com.anant.responsiveapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

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

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int densityDpi = (int) (metrics.density * 160f);

        Log.e(TAG, "getDensity:" + getDensity(this));
        Log.e(TAG, "densityDpi:" + densityDpi);
        Log.e(TAG, "getDensityName:" + getDensityName(this));
        Toast.makeText(this, ""+getDensity(this) +" densityDpi:"+densityDpi +" getDensityName:"+getDensityName(this),
                Toast.LENGTH_LONG).show();
        //getDimens();
    }

    private void getDimens() {
        try {


            float dpi =
                    (float) 1;//1 - mdpi, 0.67 - hdpi, 0.5 - xhdpi, 0.33 - xxhdpi, 0.25 - xxxhdpi
            DecimalFormat formater = new DecimalFormat("#.0#");

            dpi = 213;

            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 1; i < 1000; i++) {
            for (int i = 8; i < 60; i++) {

//                float finalVal = Float.parseFloat(formater.format(i * dpi));
                //String val = "<dimen name=\"_" + i + "dp\">" + finalVal + "dp</dimen>\n";
                float dp = Float.parseFloat(formater.format(i * 160 / dpi));

                //String val = "<dimen name=\"_" + i + "dp\">" + dp + "dp</dimen>\n";
                String val = "<dimen name=\"_" + i + "sp\">" + dp + "dp</dimen>\n";
                stringBuilder.append(val);
            }

            saveFile(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSpDimens() {
        try {
            float dpi = (float) 0.25;
            //1 - mdpi, 0.67 - hdpi, 0.5 - xhdpi, 0.33 - xxhdpi, 0.25 - xxxhdpi
            DecimalFormat formater = new DecimalFormat("#.0#");

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 8; i < 60; i++) {
                float finalVal = Float.parseFloat(formater.format(i * dpi));
                String val = "<dimen name=\"_" + i + "sp\">" + finalVal + "sp</dimen>\n";
                stringBuilder.append(val);
            }

            saveFile(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Give permission direct from settings
     * */
    private void saveFile(StringBuilder stringBuilder) {
        File logFile = new File("sdcard/Download/tvdpisp.txt");
        //File logFile = new File("sdcard/Download/tvdpi.txt");
        //File logFile = new File("sdcard/Download/xxxhsplog.txt");
        //File logFile = new File("sdcard/Download/xxhsplog.txt");
        //File logFile = new File("sdcard/Download/xhsplog.txt");
        //File logFile = new File("sdcard/Download/hsplog.txt");
        //File logFile = new File("sdcard/Download/msplog.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(stringBuilder);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        if (density >= 1.3) {
            return "tvdpi";
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
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_TV) {
                r = "tvdpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_HIGH) {
                r = "hdpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XHIGH) {
                r = "xhdpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XXHIGH) {
                r = "xxhdpi";
            } else if (metrics.densityDpi <= DisplayMetrics.DENSITY_XXXHIGH) {
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
