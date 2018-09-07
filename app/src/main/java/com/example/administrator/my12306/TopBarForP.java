package com.example.administrator.my12306;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBarForP extends RelativeLayout {
    private Button leftButton;
    private TextView titleTextView,rightText;
    private TopBarForP.OnLeftAndRightClickListener listener;//监听点击事件
    // 设置监听器
    public void setOnLeftAndRightClickListener(TopBarForP.OnLeftAndRightClickListener listener) {
        this.listener = listener; }
    // 按钮点击接口
    public interface OnLeftAndRightClickListener {
        void OnLeftButtonClick();
        void OnRightButtonClick();}
    // 设置左边按钮的可见性
    public void setLeftButtonVisibility(boolean flag){
        if (flag)
            leftButton.setVisibility(View.VISIBLE);
        else
            leftButton.setVisibility(View.GONE);
    }
    //设置右边按钮的可见性
    public void setTextVisibility(boolean flag){
        if (flag) rightText.setVisibility(View.VISIBLE);
        else rightText.setVisibility(View.GONE);
    }
    public void setTitleTextView(String titleText){
        titleTextView.setText(titleText);
    }
    public TopBarForP(Context context, AttributeSet attrs) {
        super(context, attrs); LayoutInflater.from(context).inflate(R.layout.topbarforp, this);
        leftButton =  findViewById(R.id.leftButton);
        rightText= findViewById(R.id.rightText);
        titleTextView = findViewById(R.id.titleText);
        leftButton.setOnClickListener(new OnClickListener() { @Override public void onClick(View v) {
            if (listener != null) {
                listener.OnLeftButtonClick();//点击回调
            }
        }
        });
        rightText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.OnRightButtonClick();//点击回调
                }
            }
        }); //获得自定义属性并赋值

        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.TopBarForP);
        int leftBtnBackground = typeArray.getResourceId(R.styleable.TopBarForP_leftBackbutton, 0);
        float titleTextSize = typeArray.getDimension(R.styleable.TopBarForP_titleTextSizeforp, 0);
        int titleTextColor = typeArray.getColor(R.styleable.TopBarForP_titleTextColorforp, 0x38ad5a);
        String titleText=typeArray.getString(R.styleable.TopBarForP_titleTextforp);
        String rightTx=typeArray.getString(R.styleable.TopBarForP_rightText);
        //释放资源
        typeArray.recycle();
        leftButton.setBackgroundResource(leftBtnBackground);
        titleTextView.setText(titleText);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);
        rightText.setText(rightTx);
}}
