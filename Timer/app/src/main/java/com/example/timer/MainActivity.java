package com.example.timer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private TextView mTextView;
    private int      mCount;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.d("kihoon.kim", "Timer!!!");

            mCount--;

            mTextView.setText("count = " + mCount);

            if(mCount <= 0) {
                mTextView.setText("Timer is Over");
            } else {
                mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    // 1. Text View, 숫자 넣고, 버튼 누르면, 타이머 되게 하는 것
    // 2. 시계...     1 시 58분 50초 --> 1시 59분 00 초. -> 2시 00분 00초

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCount = 5;

        mTextView = (TextView)findViewById(R.id.textview);
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("kihoon.kim", "Hello");
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }
}