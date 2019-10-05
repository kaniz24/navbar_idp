package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class gyro extends AppCompatActivity implements SensorEventListener {
    private TextView xtest_tv, ytest_tv, ztest_tv,a;
    private Sensor mysensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyro);
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SM.registerListener(gyro.this, mysensor, SensorManager.SENSOR_DELAY_NORMAL);

        xtest_tv = findViewById(R.id.x);
        ytest_tv = findViewById(R.id.y);
        ztest_tv = findViewById(R.id.z);
        a = findViewById(R.id.a);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int x = (int) event.values[0];
        int y = (int) event.values[1];
        int z = (int) event.values[2];

        xtest_tv.setText("X :" + x);
        ytest_tv.setText("Y :" + y);
        ztest_tv.setText("Z :" + z);

        if (x == 0) {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);

        } else {
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        SM.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SM.registerListener(this, mysensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
