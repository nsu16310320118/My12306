package com.example.administrator.my12306;

import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class mineFragment extends Fragment {
    private TextView name, phone, insurance, specialFood, easyTrain, travel_guide, warmpromptServe, messageService;
    private TextView havefun, dataup, system_inform, regard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.my12306_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        name = getActivity().findViewById(R.id.name);
        name.setOnClickListener(new textViewListener());
        phone = getActivity().findViewById(R.id.phone);
        phone.setOnClickListener(new textViewListener());
        insurance = getActivity().findViewById(R.id.insurance);
        insurance.setOnClickListener(new textViewListener());
        specialFood= getActivity().findViewById(R.id.specialfood);
        specialFood.setOnClickListener(new textViewListener());
        easyTrain = getActivity().findViewById(R.id.easyTrain);
        easyTrain.setOnClickListener(new textViewListener());
        travel_guide = getActivity().findViewById(R.id.travel_guide);
        travel_guide.setOnClickListener(new textViewListener());
        warmpromptServe = getActivity().findViewById(R.id.warmpromptServe);
        warmpromptServe.setOnClickListener(new textViewListener());
        messageService = getActivity().findViewById(R.id.messageService);
        messageService.setOnClickListener(new textViewListener());
        havefun = getActivity().findViewById(R.id.havefun);
        havefun.setOnClickListener(new textViewListener());
        dataup = getActivity().findViewById(R.id.dataup);
        dataup.setOnClickListener(new textViewListener());
        system_inform = getActivity().findViewById(R.id.system_inform);
        system_inform.setOnClickListener(new textViewListener());
        regard = getActivity().findViewById(R.id.regard);
        regard.setOnClickListener(new textViewListener());
    }

    private class textViewListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
        Intent intent;
            switch (view.getId()) {
                case R.id.name: {
                    intent = new Intent(getActivity(), userMes.class);
                    startActivity(intent);
                    break;
                }
            case R.id.phone:{
                intent=new Intent(getActivity(),phoneCheck.class);
                startActivity(intent);
                break;
            }
            case R.id.insurance:{
                intent=new Intent(getActivity(),myinsurance.class);
                startActivity(intent);
                break;
            }
            case R.id.specialfood:{
                Toast.makeText(getActivity(),"好吃的食物",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.easyTrain:{
                Toast.makeText(getActivity(),"铁路畅行哦",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.travel_guide:{
                intent=new Intent(getActivity(),Travel_guide.class);
                startActivity(intent);
                break;
            }
            case R.id.goodService:{
                intent=new Intent(getActivity(),warmprompt.class);
                startActivity(intent);
                break;
            }
            case R.id.messageService:{
                Toast.makeText(getActivity(),"这里是广告",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.havefun:{
                Toast.makeText(getActivity(),"这里还是广告",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.dataup:{
                Toast.makeText(getActivity(),"后续加入版本升级",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.system_inform:{
                Toast.makeText(getActivity(),"还没有通知",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.regard:{
                Toast.makeText(getActivity(),"关于",Toast.LENGTH_LONG).show();
            }
            }
        }
    }
}
