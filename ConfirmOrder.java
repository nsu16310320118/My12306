package cn.edu.nsu.a12306_program;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfirmOrder extends AppCompatActivity {
    private TextView tv_Add,Checi;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        Checi = findViewById(R.id.Checi);
        tv_Add=findViewById(R.id.tv_Add);
        btnSubmit=findViewById(R.id.btnSubmit);

        //Checi.setText("G131");
        Checi.setText(TrainDetail.Number.getNumber());

        tv_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ConfirmOrder.this,AddPassengers.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ConfirmOrder.this,PayTicket.class);
                startActivityForResult(intent,2);
            }
        });
    };
}