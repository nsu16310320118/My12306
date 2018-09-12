package cn.edu.nsu.a12306_program;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnpaidOrder extends AppCompatActivity {
    List<TrainInfo> trainList=new ArrayList<TrainInfo>();
    private Button btnPay,btnCancel;

   // ViewHolder holder=new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unpaid_order);

        init();
        final UnpaidAdapter adapter=new UnpaidAdapter(UnpaidOrder.this,R.layout.unpaid_item,trainList);
        final ListView listView=(ListView)findViewById(R.id.unpaidList);
        listView.setAdapter(adapter);

        btnPay=findViewById(R.id.btnPay);
        btnCancel=findViewById(R.id.btnCancel);
        //holder.cbChoose=findViewById(R.id.cbChoose);


//        btnPay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                for (int i=0;i<holder.trainList.size();i++){
//
//                }
//            }
//        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //holder.trainList.remove();
                trainList.remove(0);
                adapter.notifyDataSetChanged();
                Toast.makeText(UnpaidOrder.this,"成功取消",Toast.LENGTH_LONG).show();

            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
    }


    private void init() {
        TrainInfo beijing1=new TrainInfo("G131","北京","上海","13:00","18:00","5h");
        trainList.add(beijing1);
//        TrainInfo beijing2=new TrainInfo("G132","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing2);
//        TrainInfo beijing3=new TrainInfo("G133","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing3);
//        TrainInfo beijing4=new TrainInfo("G134","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing4);
//        TrainInfo beijing5=new TrainInfo("G135","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing5);
//        TrainInfo beijing6=new TrainInfo("G136","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing6);
//        TrainInfo beijing7=new TrainInfo("G137","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing7);
//        TrainInfo beijing8=new TrainInfo("G138","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing8);
//        TrainInfo beijing9=new TrainInfo("G139","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing9);
//        TrainInfo beijing10=new TrainInfo("G140","北京","上海","13:00","18:00","5h");
//        holder.trainList.add(beijing10);
    }


}
