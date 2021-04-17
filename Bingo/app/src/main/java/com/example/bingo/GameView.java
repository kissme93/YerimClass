package com.example.bingo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {

    private Paint mPaint;

    private NumberItem[][] mNumberArray;

    public GameView(Context context) {
        super(context);
        initialize();
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public void initialize() {
        mPaint = new Paint();
        mPaint.setARGB(255, 255, 0, 0);
        mNumberArray = new NumberItem[5][5];

        int count = 1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0;j<5;j++) {
                mNumberArray[i][j] = new NumberItem(count++);
            }
        }
        display();
    }

    void display() {
        for(int i = 0; i < 5; i++) {
            String strText = "";
            for(int j = 0;j<5;j++) {
                strText += mNumberArray[i][j] + " ";
            }
            Log.d("kihoon.kim", "v = " + strText);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(10, 10, 100, 100, mPaint);
    }
}
