package com.example.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class Calendar extends AppCompatActivity {

    public CalendarView calendarView;
    public EditText memoEditText;
    public TextView resultText,textView3;

    public Button save_Btn;
    public Button del_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);
        calendarView = findViewById(R.id.calendarView);

        // 한달 회고 관련
        memoEditText = findViewById(R.id.memoEditText);
        resultText=findViewById(R.id.resultText);
        textView3=findViewById(R.id.textView3);
        save_Btn = findViewById(R.id.save_Btn);
        del_Btn = findViewById(R.id.del_Btn);

        // DB
        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,
                "momo3-db").allowMainThreadQueries().build();
        resultText.setText(db.memoDao().getAll().toString());

        findViewById(R.id.resultText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoEditText.setVisibility(View.VISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.memoEditText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
            }
        });

        // 저장
        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.memoDao().insert(new Memo(memoEditText.getText().toString()));
                resultText.setText(db.memoDao().getAll().toString());

                save_Btn.setVisibility(View.INVISIBLE);
                memoEditText.setVisibility(View.INVISIBLE);
                resultText.setVisibility(View.VISIBLE);
            }
        });

        // 삭제
        del_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoEditText.setText("");

                db.memoDao().deleteAll();
                resultText.setText(db.memoDao().getAll().toString());

            }
        });

        // 날짜 선택 시
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // 한달 회고
                memoEditText.setText("");
            }
        });

        if(resultText.getText()!=null){
            memoEditText.setVisibility(View.INVISIBLE);
            resultText.setVisibility(View.VISIBLE);
        }
    }
}
