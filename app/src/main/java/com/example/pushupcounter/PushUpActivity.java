package com.example.pushupcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class PushUpActivity extends AppCompatActivity {
    private int count = 0;
    SensorManager sensorManager;
    Sensor sensor;
    TextView pushUpCounter, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);
        pushUpCounter = findViewById(R.id.textView11);
        desc = findViewById(R.id.textView12);
        pushUpCounter.setText("0");
//        pushUpCounter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                count++;
//                pushUpCounter.setText(Integer.toString(count));
//            }
//        });
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensor != null){
            sensorManager.registerListener(proximitySensorEventListener, sensor, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (sensorEvent.values[0] == 0) {
                    count++;
                    pushUpCounter.setText(Integer.toString(count));
                    desc.setText("PUSHUP");
                } else {
                    desc.setText("PUSHUP (sensor Far)");
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}