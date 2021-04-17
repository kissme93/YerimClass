package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private Paint mPaint;
    private Paint mPaint2;
    private Context mContext;

    private Canvas mCanvas;
    private Bitmap mBitmap;

    private Point mOldPt;

    public CustomView(Context context) {
        super(context);
        initialize(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    public void initialize(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.argb(255, 0, 255, 0));
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(100);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.argb(255, 255, 0, 0));
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
        this.setClickable(true);


        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);

        mBitmap = Bitmap.createBitmap(metrics.widthPixels, metrics.heightPixels, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        mOldPt = new Point();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (false) {
            canvas.drawLine(10, 10, 100, 100, mPaint);

            canvas.drawRect(new Rect(100, 100, 200, 200), mPaint2);

            canvas.drawCircle(30, 30, 30, mPaint);
            canvas.drawCircle(60, 30, 30, mPaint2);
            canvas.drawOval(new RectF(10, 10, 30, 80), mPaint);

            Drawable drawable = mContext.getResources().getDrawable(R.drawable.micky);
            drawable.setBounds(new Rect(100, 10, 160, 60));
            drawable.draw(canvas);
        }
        canvas.drawText("Hello", 100, 100, mPaint);


        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("kihoon.kim", "event = " + event);
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();

            mOldPt.set((int)x, (int)y);

        }else if(event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();

            mCanvas.drawLine(mOldPt.x, mOldPt.y, x, y, mPaint);
            mOldPt.set((int)x, (int)y);
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
