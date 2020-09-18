package com.example.pushupcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout container = findViewById(R.id.container_pushup_main);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pushUp = new Intent(MainActivity.this, PushUpActivity.class);
                startActivity(pushUp);
            }
        });
    }
}