package com.example.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    class Time {
        private int mHour;
        private int mMinute;
        private int mSecond;

        public Time(int hour, int minute, int second) {
            mHour = hour;
            mMinute = minute;
            mSecond = second;
        }

        public void passTime() {
            mSecond ++;
            if(mSecond >= 60) {
                mMinute++;
                mSecond = 0;
            }
            if (mMinute >= 60) {
                mHour ++;
                mMinute = 0;
            }
            if (mHour >=12) {
                mHour = 1;
            }
        }

        public void display() {
            Log.d("kihoon.kim", " 시간 : " + mHour + ":" + mMinute + ":" + mSecond);
        }
    }

    private Time mTime;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            mTime.passTime();
            mTime.display();
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTime = new Time(1, 59, 50);

        mHandler.sendEmptyMessageDelayed(0, 1000);

    }
}