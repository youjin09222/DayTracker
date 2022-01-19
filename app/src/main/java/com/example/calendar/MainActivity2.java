package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


class MainActivity2 extends AppCompatActivity {

    int start_save;
    int end_save;
    int select_number_start;
    int select_number_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int[] timetable1 = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,1,2,3,4,5};
        int[] timetable2 = {24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};

        Spinner start_time = (Spinner) findViewById(R.id.start_time);
        start_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_number_start=start_time.getSelectedItemPosition();
                start_save=timetable1[select_number_start];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                start_save=timetable1[0];
            }
        });

        Spinner end_time = (Spinner) findViewById(R.id.end_time);
        end_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_number_end=start_time.getSelectedItemPosition();
                end_save=timetable2[select_number_end];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                end_save=timetable2[0];
            }
        });

        Button start_button=findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 =new Intent(MainActivity2.this,MainActivity.class);
                intent2.putExtra("start_save",start_save);
                intent2.putExtra("end_save",end_save);
                startActivity(intent2);
            }
        });


    }
}