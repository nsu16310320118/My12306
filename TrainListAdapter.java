package cn.edu.nsu.a12306_program;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LD on 2018/8/30.
 */

public class TrainListAdapter extends ArrayAdapter{
    private int resourceId;

    public TrainListAdapter(@NonNull Context context, int resource, List<TrainDetail.Number> objects) {
        super(context, resource,objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrainDetail.Number number=(TrainDetail.Number)getItem(position);//获取车次实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView trainNumber=(TextView)view.findViewById(R.id.number);
        trainNumber.setText(TrainDetail.Number.getNumber());
        return view;
    }
}
