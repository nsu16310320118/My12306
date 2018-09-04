package cn.edu.nsu.a12306_program;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static cn.edu.nsu.a12306_program.AddPassengers.*;

/**
 * Created by LD on 2018/9/4.
 */

public class PassengerAdapter extends ArrayAdapter{
    private int resourceId;

    public PassengerAdapter(@NonNull Context context, int resource, List<AddPassengers.Passenger> objects) {

        super(context, resource,objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AddPassengers.Passenger passenger = (AddPassengers.Passenger) getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView name=(TextView)view.findViewById(R.id.name);
        name.setText(passenger.getName());

        TextView IdNumber=(TextView)view.findViewById(R.id.Id);
        IdNumber.setText(passenger.getIdNumber());

        TextView HumanType=(TextView)view.findViewById(R.id.HumanType);
        HumanType.setText(passenger.getHumanType());
        return view;
    }
}
