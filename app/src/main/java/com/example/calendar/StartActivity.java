package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this,MainActivity3.class));
            }
        };
        handler.postDelayed(runnable,2500);

    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}