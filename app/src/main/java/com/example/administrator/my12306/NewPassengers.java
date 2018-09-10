package com.example.administrator.my12306;

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

public class NewPassengers extends AppCompatActivity {

    private TextView edtName,edtGender, edtBirthday, edtCountry, edtCardLei, edtTourLei,edtcardNo;
    private int year, month, day;
    private TopBarForP topBarForP;

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
        setContentView(R.layout.activity_new_passengers);
        edtName=findViewById(R.id.edtPsgName);
        edtGender =  findViewById(R.id.edtGender);
        edtBirthday =  findViewById(R.id.edtBirthday);
        edtCountry =  findViewById(R.id.edtCountry);
        edtCardLei = findViewById(R.id.edtCardLei);
        edtTourLei =  findViewById(R.id.edtTourLei);
        edtcardNo=findViewById(R.id.edtcardNo);
        topBarForP=findViewById(R.id.topbarforp);
        topBarForP.setTitleTextView("新乘客");
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
        topBarForP.setOnLeftAndRightClickListener(new TopBarForP.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
                Intent newIntent=getIntent();
                newIntent.putExtra("userName",edtName.getText().toString());
                newIntent.putExtra("IDNumber",edtcardNo.getText().toString());
                newIntent.putExtra("HumanType",edtTourLei.getText().toString());
                int requestCode=0x102;
                setResult(requestCode,newIntent);
                finish();

            }
        });

    }

    private class dialogListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.edtGender:
                    final String[] gender = {"男", "女"};
                    final AlertDialog.Builder builder = new AlertDialog.Builder(NewPassengers.this);
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
                            DatePickerDialog dialog = new DatePickerDialog(NewPassengers.this, android.app.AlertDialog.THEME_HOLO_LIGHT,dateListener, year, month, day);
                            dialog.show();
                        }
                    });
                    break;
                case R.id.edtCountry:
                    Intent intent = new Intent(NewPassengers.this, Country.class);
                    startActivity(intent);
                    break;
                case R.id.edtCardLei:
                    final String[] card = {"二代身份证", "港澳居民来往内地通行证", "台湾居民来往大陆通行证", "护照"};
                    AlertDialog.Builder cbuilder = new AlertDialog.Builder(NewPassengers.this);
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
                    AlertDialog.Builder tbuilder = new AlertDialog.Builder(NewPassengers.this);
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
