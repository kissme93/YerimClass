package com.example.bingo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class GameView extends View {

    class Point {
        public int x;
        public int y;

        @Override
        public String toString() {
//            return "Point{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
            return "" + x + ", " +y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    };

    private Paint mPaint;

    private NumberItem[][] mNumberArray;

    private Random mRandom;

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
        mPaint.setARGB(255, 0, 0, 0);
        mPaint.setTextSize(60);
        mPaint.setStrokeWidth(3);

        mNumberArray = new NumberItem[5][5];

        int count = 1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0;j<5;j++) {
                mNumberArray[j][i] = new NumberItem(count++);
            }
        }
        display();

        mRandom = new Random();

        for(int i=0;i<100;i++) {
            shuffle();
        }

        display();

        setClickable(true);
    }

    void shuffle() {
        int value1 = mRandom.nextInt(25);//0 ~ 24
        int value2 = mRandom.nextInt(25);//0 ~ 24

        NumberItem temp;
        temp = mNumberArray[value1/5][value1%5];
        mNumberArray[value1/5][value1%5] = mNumberArray[value2/5][value2%5];
        mNumberArray[value2/5][value2%5] = temp;
    }

    void display() {
        for(int i = 0; i < 5; i++) {
            String strText = "";
            for(int j = 0;j<5;j++) {
                strText += mNumberArray[j][i] + " ";
            }
            Log.d("kihoon.kim", "v = " + strText);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawLine(10, 10, 100, 100, mPaint);
        for(int i = 0; i < 5; i++) {
            for(int j = 0;j<5;j++) {
                String strText;
                strText = String.format("%2d", mNumberArray[j][i].mNumber);
                canvas.drawText(strText, j * 80 + 100, (i + 1) * 80 + 80, mPaint);

                // X 표시
                if (mNumberArray[j][i].mSelect) {
                    canvas.drawLine( (j) * 80 + 100, (i + 1) * 80 + 100, (j + 1) * 80 + 100, (i) * 80 + 100, mPaint);
                    canvas.drawLine( (j) * 80 + 100, (i) * 80 + 100, (j+1) * 80 + 100, (i + 1) * 80 + 100, mPaint);
                }

            }
        }

        for(int i = 0;i<6; i++) {
            canvas.drawLine(100, i * 80 + 100, 500, i * 80 + 100, mPaint);
            canvas.drawLine(i * 80 + 100, 100, i * 80 + 100, 500, mPaint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("kihoon.kim", "" + event);

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            Log.d("kihoon.kim", "" + getLocation(x, y));
            Point clickedPoint = getLocation(x, y);
            mNumberArray[clickedPoint.x][clickedPoint.y].mSelect = true;
            invalidate();
        }

        return super.onTouchEvent(event);
    }

    public Point getLocation(int LocX, int LocY) {
        return new Point((LocX - 100)/80, (LocY -100)/80);
    }
}
