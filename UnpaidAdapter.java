package cn.edu.nsu.a12306_program;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LD on 2018/9/11.
 */

public class UnpaidAdapter extends ArrayAdapter{

    Button btnCancel;
    private int resourceId;
    //HashMap<Integer,Boolean> isSelected;
    private TextView startDate,fromCity,startTime,toCity,arriveTime,
            trainNo,seatType,carriageNo,seatNo,
            paserName,IdType,peopleType,ticketPrice,ticketType;


    public UnpaidAdapter(@NonNull Context context, int resource, List objects) {
        super(context, resource,objects);
        resourceId=resource;
        //init();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrainInfo trainInfo=(TrainInfo) getItem(position);//获取列车实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);


        startDate=(TextView)view.findViewById(R.id.startDate);
        fromCity=(TextView)view.findViewById(R.id.fromCity);
        startTime=(TextView)view.findViewById(R.id.startTime);
        toCity=(TextView)view.findViewById(R.id.toCity);
        arriveTime=(TextView)view.findViewById(R.id.arriveTime);
        trainNo=(TextView)view.findViewById(R.id.trainNo);
        seatType=(TextView)view.findViewById(R.id.seatType);
        carriageNo=(TextView)view.findViewById(R.id.carriageNo);
        seatNo=(TextView)view.findViewById(R.id.seatNo);
        paserName=(TextView)view.findViewById(R.id.paserName);
        IdType=(TextView)view.findViewById(R.id.IdType);
        peopleType=(TextView)view.findViewById(R.id.peopleType);
        ticketPrice=(TextView)view.findViewById(R.id.ticketPrice);
        ticketType=(TextView)view.findViewById(R.id.ticketType);
//        btnCancel=(Button)view.findViewById(R.id.btnCancel);

        fromCity.setText(trainInfo.getFromCity());
        startTime.setText(trainInfo.getStartTime());
        toCity.setText(trainInfo.getToCity());
        arriveTime.setText(trainInfo.getArriveTime());
        trainNo.setText(trainInfo.getTrainNo());

//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                trainList.remove(position);
//            }
//        });

        //view.setTag(holder);
        //holder.cbChoose.setChecked(isSelected.get(position));
        return view;
    }
//    private void init() {
//        isSelected=new HashMap<Integer, Boolean>();
//        for (int i=0; i<10;i++){
//            isSelected.put(i,false);
//        }
//    }

//    class ViewHolder{
//        //CheckBox cbChoose;
//        List<TrainInfo> trainList=new ArrayList<TrainInfo>();
//    }
}