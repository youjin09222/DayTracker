package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    public ImageButton calendarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        calendarBtn = findViewById(R.id.calendarBtn);

        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_cal =new Intent(MainActivity1.this, com.example.calendar.CalendarActivity.class);
                startActivity(intent_cal);//액티비티 이동
            }
        });

        Button switch1=findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 =new Intent(MainActivity1.this,MainActivity.class);
                startActivity(intent4);
            }
        });

    }
}