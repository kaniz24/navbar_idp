package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

public class shake extends AppCompatActivity implements ShakeDetector.Listener {

    SensorManager sensorManager;
    TextView T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        T=(TextView)findViewById(R.id.a);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        ShakeDetector sd=new ShakeDetector(this);

        sd.start(sensorManager);
    }


    @Override
    public void hearShake() {


        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel : 01951760868"));
        //startActivity(phoneIntent);

    }
}
