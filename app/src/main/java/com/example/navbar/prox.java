package com.example.navbar;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class prox extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        proximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        sensorManager.registerListener(prox.this,proximity,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        if(sensorEvent.values[0]<proximity.getMaximumRange())
        {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
        else
        {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {



    }
}