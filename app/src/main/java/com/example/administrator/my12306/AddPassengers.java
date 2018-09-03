package com.example.aurora.t12306;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class AddPassengers extends AppCompatActivity {

    private TextView edtGender, edtBirthday, edtCountry, edtCardLei, edtTourLei;
    private int year, month, day;

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year = i;
            month = i1;
            day = i2;
            update();
        }

        private void update() {
            edtBirthday.setText(year + "-" + (month+1) + "-" + day);
        }

    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_passengers);

        edtGender = (TextView) findViewById(R.id.edtGender);
        edtBirthday = (TextView) findViewById(R.id.edtBirthday);
        edtCountry = (TextView) findViewById(R.id.edtCountry);
        edtCardLei = (TextView) findViewById(R.id.edtCardLei);
        edtTourLei = (TextView) findViewById(R.id.edtTourLei);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        edtBirthday.setText(year + "-" + (month+1) + "-" + day);

        edtGender.setOnClickListener(new dialogListener());
        edtBirthday.setOnClickListener(new dialogListener());
        edtCountry.setOnClickListener(new dialogListener());
        edtCardLei.setOnClickListener(new dialogListener());
        edtTourLei.setOnClickListener(new dialogListener());

    }

    private class dialogListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.edtGender:
                    final String[] gender = {"男", "女"};
                    final AlertDialog.Builder builder = new AlertDialog.Builder(AddPassengers.this);
                    builder.setSingleChoiceItems(gender, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edtGender.setText(gender[i]);
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();

                    break;
                case R.id.edtBirthday:

                    edtBirthday.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DatePickerDialog dialog = new DatePickerDialog(AddPassengers.this, android.app.AlertDialog.THEME_HOLO_LIGHT,dateListener, year, month, day);
                            dialog.show();
                        }
                    });
                    break;
                case R.id.edtCountry:
                    Intent intent = new Intent(AddPassengers.this, Country.class);
                    startActivity(intent);
                    break;
                case R.id.edtCardLei:
                    final String[] card = {"二代身份证", "港澳居民来往内地通行证", "台湾居民来往大陆通行证", "护照"};
                    AlertDialog.Builder cbuilder = new AlertDialog.Builder(AddPassengers.this);
                    cbuilder.setSingleChoiceItems(card, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edtCardLei.setText(card[i]);
                            dialogInterface.dismiss();
                        }
                    });
                    cbuilder.show();
                    break;
                case R.id.edtTourLei:
                    AlertDialog.Builder tbuilder = new AlertDialog.Builder(AddPassengers.this);
                    final String[] tour = {"成人", "儿童", "学生", "残军"};
                    tbuilder.setSingleChoiceItems(tour, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edtTourLei.setText(tour[i]);
                            dialogInterface.dismiss();
                        }
                    });
                    tbuilder.show();
                    break;
            }
        }
    }

}
