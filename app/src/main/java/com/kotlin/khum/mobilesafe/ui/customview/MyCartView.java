package com.kotlin.khum.mobilesafe.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/2
 *     desc   : 购物车控件
 * </pre>
 */
public class MyCartView extends View {

    private Paint mPaint;
    private Canvas mCanvas;
    private int mWidth;
    private int mHeight;
    private int mCart_background;
    private String mText;
    private int mTextColor;
    private RectF mRectF;
    private int mTextSize;

    public MyCartView(Context context) {
        this(context, null);
    }

    public MyCartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        initPaint();
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCartView);
        mCart_background = typedArray.getColor(R.styleable.MyCartView_cart_background, Color.parseColor("#32ce69"));
        mText = typedArray.getString(R.styleable.MyCartView_text).toString();
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.MyCartView_textSize, sp2px(14));
        mTextColor = typedArray.getColor(R.styleable.MyCartView_textColor, Color.parseColor("#111111"));
        typedArray.recycle();
    }

    //初始化画笔
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(8f);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.mCanvas = canvas;
        drawBackground();
        drawText();
    }

    //绘制文字
    private void drawText() {
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
        Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
        float top = fm.top;
        float bottom = fm.bottom;
        int baseLineY = (int) (mRectF.centerY() - top/2 - bottom/2);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mCanvas.drawText(mText, mRectF.centerX(), baseLineY, mPaint);
    }

    //绘制背景
    private void drawBackground() {
        mPaint.setColor(mCart_background);
        mRectF = new RectF(0, 0, mWidth, mHeight);
        mCanvas.drawRoundRect(mRectF, 10, 10, mPaint);
    }

    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
