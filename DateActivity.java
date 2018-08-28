package com.example.aurora.t12306;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;

import java.util.Date;

public class DateActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    private DatePicker picker;
    private boolean flag = false;
    private int year, month, day;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        Calendar calendar = Calendar.getInstance();
        picker = (DatePicker) findViewById(R.id.datePicker);
        picker.setMinDate(new Date().getTime());
        calendar.add(Calendar.MONTH, 1);
        picker.setMaxDate(calendar.getTimeInMillis());

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        picker.init(year, month, day, this);
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("year", year);
        bundle.putInt("month", month);
        bundle.putInt("day", day);
        intent.putExtras(bundle);
        setResult(6, intent);
        finish();
    }
}
