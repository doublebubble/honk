package com.gethonk.honk;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Design and Implementation of Analog Clock
 */
public class AnalogClockView extends View {

    // same as ratio of len of hands for Big Ben
    float HOUR_HAND_TO_MINUTE_HAND_RATIO = 1.59259259259259259259f;
    float HOUR_HAND_LEN = 100f;
    float MINUTE_HAND_LEN = HOUR_HAND_TO_MINUTE_HAND_RATIO * HOUR_HAND_LEN;

    float CENTER_CLOCK_CICLE_RADIUS = 4.0f;
    float CLOCK_PERIMITER_STROKE_WIDTH = 8.0f;
    float CLOCK_HANDS_STROKE_WIDTH = 6.0f;


    Paint mPaint, mFillPaint, mHandPaint;
    private Context ctx;
    float mScreenWidth, mScreenHeight, mRadius;

    public AnalogClockView(Context context) {
        super(context);
        init(null, 0);
    }

    public AnalogClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init(attrs, 0);

        // paint brush for drawing clock perimiter
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(CLOCK_PERIMITER_STROKE_WIDTH);

        // paint brush for drawing center of clock circle
        mFillPaint = new Paint();
        mFillPaint.setAntiAlias(true);
        mFillPaint.setColor(Color.BLACK);
        mFillPaint.setStyle(Paint.Style.FILL);
        mFillPaint.setStrokeWidth(2.0f);

        // paint brush for drawing hands of clock
        mHandPaint = new Paint();
        mHandPaint.setAntiAlias(true);
        mHandPaint.setColor(Color.BLACK);
        mHandPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mHandPaint.setStrokeWidth(CLOCK_HANDS_STROKE_WIDTH);
    }

    public AnalogClockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes

    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float xCenter, yCenter;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = ctx.getResources().getDisplayMetrics();
        mScreenWidth = (float) displayMetrics.widthPixels;
        mScreenHeight = (float) displayMetrics.heightPixels;
        xCenter = mScreenWidth/2f;
        yCenter = mScreenHeight/4f;
        mRadius = mScreenWidth/5f;

        // draw hands
        canvas.drawLine(xCenter, yCenter, xCenter, yCenter-MINUTE_HAND_LEN, mHandPaint);
        canvas.drawLine(xCenter, yCenter, xCenter+HOUR_HAND_LEN, yCenter, mHandPaint);

        // draw center circle
        canvas.drawCircle(xCenter, yCenter, CENTER_CLOCK_CICLE_RADIUS, mFillPaint);

        // draw clock perimiter
        canvas.drawCircle(xCenter, yCenter, mRadius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
