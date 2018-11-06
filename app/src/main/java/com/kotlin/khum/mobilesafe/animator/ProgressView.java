package com.kotlin.khum.mobilesafe.animator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/5
 *     desc   :
 * </pre>
 */
public class ProgressView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mProgressColor;
    private float mProgressWidth;
    private int mWidth;
    private int mHeight;
    private RectF mRectF;
    private float mProgress;
    private float mTextSize;
    private int mTextColor;
    private int[] mColors = new int[]{
            0xFF660099,//紫色
            0xFFFF0000,//红色
            0xFFFFFF00,//黄色
            0xFFFF6600,//橘色
            0xFFFF6600,//橘色
            0xFFFFFF00,//黄色
            0xFFFF0000,//红色
            0xFF660099,//紫色
    };

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
        invalidate();
    }

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressView);
        mProgressColor = typedArray.getColor(R.styleable.ProgressView_pv_progressColor, ContextCompat.getColor(context, R.color.colorAccent));
        mProgressWidth = typedArray.getDimension(R.styleable.ProgressView_pv_width, 40);
        mTextSize = typedArray.getDimension(R.styleable.ProgressView_pv_textSize, sp2px(14));
        mTextColor = typedArray.getColor(R.styleable.ProgressView_pv_textColor, Color.BLACK);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int edge = mHeight>mWidth? mWidth:mHeight;
        mRectF = new RectF(mProgressWidth, mProgressWidth, edge-mProgressWidth, edge-mProgressWidth);
        drawProgress(canvas);
        drawText(canvas);
    }

    //一行代码调用
    public void doAnimation(float endValue) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, endValue).setDuration(2000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    private void drawText(Canvas canvas) {
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
        mPaint.setStrokeWidth(2f);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
        int top = fm.top;
        int bottom = fm.bottom;
        float baseLine = mRectF.centerY() - (top + bottom) / 2;
        canvas.drawText(String.valueOf((int)(mProgress*100))+"%", mRectF.centerX(), baseLine, mPaint );
    }

    private void drawProgress(Canvas canvas) {
        SweepGradient sweepGradient = new SweepGradient(0,0,mColors, null);
        mPaint.setShader(sweepGradient);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mProgressWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(mRectF,150,360*mProgress, false, mPaint);
    }

    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
