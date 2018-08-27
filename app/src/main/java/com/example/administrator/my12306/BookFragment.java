package com.example.administrator.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class BookFragment extends Fragment {
    private TextView from,to,godate,gotime;
    private ImageView change;
    private CheckBox student;
    private Button query;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.book_layout,container,false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            from.setText(data.getStringExtra("site"));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        from=getActivity().findViewById(R.id.From);
        to=getActivity().findViewById(R.id.to);
        godate=getActivity().findViewById(R.id.GoDate);
        gotime=getActivity().findViewById(R.id.GoTime);
        change=getActivity().findViewById(R.id.change);
        student=getActivity().findViewById(R.id.student);
        query=getActivity().findViewById(R.id.query);
    }
    private class textViewListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case R.id.From:{
                    intent=new Intent(getActivity(),from.class);
                    startActivityForResult(intent,1);
                    break;
                }
            }
        }
    }
}
