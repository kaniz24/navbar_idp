package com.example.navbar;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class acc extends AppCompatActivity implements SensorEventListener {


    private TextView tv_x1,tv_y1,tv_z1,bg;
    private Sensor mySensor1;
    private SensorManager SM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        SM= (SensorManager) getSystemService(SENSOR_SERVICE);

        mySensor1=SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this,mySensor1,SensorManager.SENSOR_DELAY_NORMAL);


        tv_x1=findViewById(R.id.x);
        tv_y1=findViewById(R.id.y);
        tv_z1=findViewById(R.id.z);
        bg=findViewById(R.id.a);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int x = (int) event.values[0];
        int y = (int) event.values[1];
        int z = (int) event.values[2];

        if(y==0)
        {
            bg.setBackgroundColor(Color.CYAN);
        }
        else
        {
            bg.setBackgroundColor(Color.rgb(255,255,255));
        }

        tv_x1.setText(String.valueOf("X is: "+x));
        tv_y1.setText(String.valueOf("Y is: "+y));
        tv_z1.setText(String.valueOf("Z is: "+z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected  void onResume()
    {
        super.onResume();
        SM.registerListener(this,mySensor1,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected  void onPause()
    {
        super.onPause();

        SM.unregisterListener(this);
    }
}
