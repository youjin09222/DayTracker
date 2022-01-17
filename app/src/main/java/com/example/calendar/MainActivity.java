package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    public String fname = null;
    public String str = null;
    public CalendarView calendarView;
    public EditText freeEditText;
    public TextView textView2;
    public Button save_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        //TextView selectedDay = findViewById(R.id.selectedDay);

        // 한달 회고 관련
        freeEditText = findViewById(R.id.freeEditText);
        save_Btn = findViewById(R.id.save_Btn);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //선택한 날짜 표시
                // selectedDay.setText(String.format("%d / %d / %d",year,month+1,dayOfMonth));
                // 한달 회고
                freeEditText.setText("");
            }
        });

        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = freeEditText.getText().toString();
                textView2.setText(str);
                save_Btn.setVisibility(View.INVISIBLE);
                freeEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
            }
        });
    }
}
