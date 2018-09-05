package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddPassengers extends AppCompatActivity {
    //private List passenger=new ArrayList();
    //private String[] list={"王二","张三","李四"};
    private List<Passenger> passengerList=new ArrayList<Passenger>();
    private TopBarForP topBarForP;
    private ListView passengers;
    private CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_passengers);
        initPassenger();

        cb=LayoutInflater.from(AddPassengers.this).inflate(R.layout.passenger_info,null).findViewById(R.id.cb);
        PassengerAdapter adapter=new PassengerAdapter(AddPassengers.this,R.layout.passenger_info,passengerList);
        passengers=findViewById(R.id.passengerList);
        passengers.setAdapter(adapter);
        passengers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                RecyclerView.ViewHolder holder= (RecyclerView.ViewHolder) view.getTag();
                cb.toggle();
                Toast.makeText(AddPassengers.this,"框被选择了",Toast.LENGTH_LONG).show();
            }
        });
        topBarForP=findViewById(R.id.topbarforp);
        topBarForP.setTitleTextView("添加乘客");
       topBarForP.setOnLeftAndRightClickListener(new TopBarForP.OnLeftAndRightClickListener() {
           @Override
           public void OnLeftButtonClick() {
               finish();
           }

           @Override
           public void OnRightButtonClick() {

           }
       });
    }

    private void initPassenger() {
        Passenger wanger=new Passenger("王二","成人","2222****2222");
        passengerList.add(wanger);

        Passenger zhangsan=new Passenger("张三","学生","3333****3333");
        passengerList.add(zhangsan);

        Passenger lisi=new Passenger("李四","成人","4444****4444");
        passengerList.add(lisi);
    }



    public class Passenger{
        private String name;
        private String HumanType;
        private String IdNumber;

        public Passenger(String name, String HumanType, String IdNumber){
            this.name=name;
            this.IdNumber=IdNumber;
            this.HumanType=HumanType;
        }

        public String getName() {
            return name;
        }

        public String getIdNumber() {
            return IdNumber;
        }

        public String getHumanType() {
            return HumanType;
        }
    }


}
