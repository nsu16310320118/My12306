package com.example.administrator.my12306;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class finishFragment extends Fragment {

    private TextView today,unGo,history,todayOrder;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        today=getActivity().findViewById(R.id.today);
        unGo=getActivity().findViewById(R.id.unGo);
        history=getActivity().findViewById(R.id.history);
        todayOrder=getActivity().findViewById(R.id.todayOrder);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int mouth = calendar.get(calendar.MONTH) + 1;
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String date = year + "年" + mouth + "月" + day + "日";
//        switch (dayWeek) {
//            case 1:
//                today.setText(date + "星期日");
//                break;
//            case 2:
//                today.setText(date + "星期一");
//                break;
//            case 3:
//                today.setText(date + "星期二");
//                break;
//            case 4:
//                today.setText(date + "星期三");
//                break;
//            case 5:
//                today.setText(date + "星期四");
//                break;
//            case 6:
//                today.setText(date + "星期五");
//                break;
//            case 7:
//                today.setText(date + "星期六");
//                break;
//        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.finish, container, false);
    }


}

