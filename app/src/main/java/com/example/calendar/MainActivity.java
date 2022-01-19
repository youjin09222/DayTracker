package com.example.calendar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public ImageButton calendarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);

        Intent intent1 = getIntent();
        int start_save = intent1.getIntExtra("start_save", 6);
        int end_save = intent1.getIntExtra("end_save", 24);

        calendarBtn = findViewById(R.id.calendarBtn);

        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_cal =new Intent(MainActivity.this, com.example.calendar.CalendarActivity.class);
                startActivity(intent_cal);//액티비티 이동
            }
        });

        Button switch1=findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 =new Intent(MainActivity.this, com.example.calendar.MainActivity1.class);
                startActivity(intent3);
            }
        });

    }
}


