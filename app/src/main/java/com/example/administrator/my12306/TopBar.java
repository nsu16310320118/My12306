package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {
        private Button leftButton, rightButton,changeButton;
        private TextView fromCity,toCity;
        private OnLeftAndRightClickListener listener;//监听点击事件

        //设置监听器
        public void setOnLeftAndRightClickListener(OnLeftAndRightClickListener listener) {
            this.listener = listener;
        }

        //按钮点击接口
        public interface OnLeftAndRightClickListener {
            void OnLeftButtonClick();
            void OnRightButtonClick();
            void OnChangeButtonClick();
        }
        //设置左边按钮的可见性
        public void setLeftButtonVisibility(boolean flag){
            if (flag)
                leftButton.setVisibility(View.VISIBLE);
            else
                leftButton.setVisibility(View.GONE);
        }

        //设置右边按钮的可见性
        public void setRightButtonVisibility(boolean flag){
            if (flag)
                rightButton.setVisibility(View.VISIBLE);
            else
                rightButton.setVisibility(View.GONE);
        }
        public void setChangeButtonVisibility(boolean flag){
            if (flag)
                changeButton.setVisibility(View.VISIBLE);
            else
                changeButton.setVisibility(View.GONE);
        }
        public TopBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            LayoutInflater.from(context).inflate(R.layout.layout_topbar, this);
            leftButton =findViewById(R.id.leftButton);
            rightButton =  findViewById(R.id.rightButton);
            fromCity= findViewById(R.id.fromCiry);
            toCity=findViewById(R.id.toCity);
            leftButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnLeftButtonClick();//点击回调
                    }
                }
            });
            rightButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnRightButtonClick();//点击回调
                    }
                }
            });
            changeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        listener.OnChangeButtonClick();//点击回调
                    }
                }
            });

            //获得自定义属性并赋值
            TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
            int leftBtnBackground = typeArray.getResourceId(R.styleable.TopBar_leftBackground, 0);
            int rightBtnBackground = typeArray.getResourceId(R.styleable.TopBar_rightChoose, 0);
            int changeBtnBackground=typeArray.getResourceId(R.styleable.TopBar_changeButton,0);
            //释放资源
            typeArray.recycle();
            leftButton.setBackgroundResource(leftBtnBackground);
            rightButton.setBackgroundResource(rightBtnBackground);
            changeButton.setBackgroundResource(changeBtnBackground);
        }
    }
