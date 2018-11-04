package com.kotlin.khum.mobilesafe.ui.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/2
 *     desc   :
 * </pre>
 */
public class SubCartView extends View {

    private Paint mPaint;
    private int mCircleColor;
    private int mRightColor;
    private int mTextColor;
    private String mText;
    private float mTextSize;
    private int mWidth;
    private int mHeight;
    private Canvas mCanvas;
    private float circleStroke = 4f;
    private int mPlusColor;
    private RectF mRectF;
    private RectF mRightRect;
    private RectF mLeftRectF;
    private int mQuantity;
    private Path mLeftPath;
    private int mGap;
    protected float progress;//收缩进度 0 表示操作， 1 为加入购物车

    protected boolean isHint;
    private Path mCartPath;
    private RectF mOuterRect;
    private QuantityChangedListener mQuantityChangedListener;

    public SubCartView(Context context) {
        this(context, null);
    }

    public SubCartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubCartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        initPaint();
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SubCartView);
        mCircleColor = typedArray.getColor(R.styleable.SubCartView_svc_circleColor, Color.parseColor("#aaaaaa"));
        mRightColor = typedArray.getColor(R.styleable.SubCartView_svc_rightColor, Color.parseColor("#13ab48"));
        mTextColor = typedArray.getColor(R.styleable.SubCartView_svc_textColor, Color.parseColor("#666666"));
        mPlusColor = typedArray.getColor(R.styleable.SubCartView_svc_plus_color, Color.parseColor("#ffffff"));
        mText = typedArray.getString(R.styleable.SubCartView_svc_text);
        mQuantity = Integer.parseInt(mText);
        mTextSize = typedArray.getDimension(R.styleable.SubCartView_svc_textSize, sp2px(14));
        typedArray.recycle();
    }

    //初始化画笔
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(circleStroke);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mGap = mWidth - mHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.mCanvas = canvas;
        if (isHint){
            mQuantity =1;
            drawCart();
        }else{
            drawLeftCircle();
            drawRightCircle();
            drawText();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private void drawCart() {
        if (mCartPath==null)
        mCartPath = new Path();
        mCartPath.reset();
        mOuterRect = new RectF(mGap*progress, 0, mWidth, mHeight);
        mCartPath.addRoundRect(mOuterRect, mHeight/2, mHeight/2, Path.Direction.CW);
        mPaint.setColor(mRightColor);
        mCanvas.drawPath(mCartPath, mPaint);
        //绘制文字
        mPaint.setAlpha((int) ((1-progress)*255));
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(mTextSize);
        mPaint.setStrokeWidth(1f);
        Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
        float top = fm.top;
        float bottom = fm.bottom;
        int baseLineY = (int) (mRectF.centerY() - top/2 - bottom/2);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mCanvas.drawText("加入购物车", mRectF.centerX(), baseLineY, mPaint);
    }

    private void drawText() {
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
        mPaint.setStrokeWidth(2f);
        mPaint.setAlpha((int) ((1-progress)*255));
        if(mRectF==null){
            mRectF = new RectF(0,0,mWidth, mHeight);
        }
        float centerY = mRectF.centerY();
        mPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
        float top = fm.top;
        float bottom = fm.bottom;
        float baseLineY = centerY - (top + bottom) / 2;
        mCanvas.drawText(String.valueOf(mQuantity), mRectF.centerX()+mGap/2*progress, baseLineY, mPaint);
    }

    private void drawRightCircle() {
        mRightRect = new RectF(mWidth - mHeight, 0, mWidth, mHeight);
        mPaint.setColor(mRightColor);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mCanvas.drawCircle(mWidth- mHeight/2, mHeight/2, mHeight/2-circleStroke, mPaint);
        mPaint.setColor(mPlusColor);
        mPaint.setStrokeWidth(circleStroke);
        float sin = (float) Math.sin(Math.PI * progress/2);
        float cos = (float) Math.cos(Math.PI * progress/2);
        mCanvas.drawLine(mWidth-mHeight/2-3*mHeight*cos/10, mHeight/2-3*mHeight*sin/10,
                mWidth-mHeight/2+3*mHeight*cos/10, mHeight/2+3*mHeight*sin/10, mPaint);
        mCanvas.drawLine(mWidth-mHeight/2+3*mHeight*sin/10, mHeight/2-cos*3*mHeight/10,
                mWidth-mHeight/2-3*mHeight*sin/10, mHeight/2+cos*3*mHeight/10, mPaint);
    }

    private void drawLeftCircle() {
        mLeftRectF = new RectF(0, 0, mHeight, mHeight);
        if (mLeftPath==null){
            mLeftPath = new Path();
        }
        mPaint.setColor(mCircleColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(circleStroke);
        mPaint.setAlpha((int) ((1-progress)*255));
        mLeftPath.reset();
        mLeftPath.addCircle(mHeight/2+mGap*progress, mHeight/2, mHeight/2-circleStroke, Path.Direction.CW);
        mCanvas.drawPath(mLeftPath, mPaint);
        float sin = (float) Math.sin(Math.PI * progress/2);
        float cos = (float) Math.cos(Math.PI * progress/2);
        mCanvas.drawLine(mGap*progress+mHeight/2+3*mHeight*cos/10, mHeight/2+3*mHeight*sin/10,
                mGap*progress+mHeight/2-3*mHeight*cos/10, mHeight/2-3*mHeight*sin/10, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                float x_up = event.getX();
                float y_up = event.getY();
                if (isHint){
                    showCounter();
                }else{
                    if (mRightRect.contains(x_up, y_up)){
                        increase();
                        if (mQuantityChangedListener!=null){
                            mQuantityChangedListener.quantityChanged(this, mQuantity, true);
                        }
                    }
                    if (mLeftRectF.contains(x_up, y_up)){
                        decrease();
                        if (mQuantityChangedListener!=null){
                            mQuantityChangedListener.quantityChanged(this, mQuantity, false);
                        }
                    }
                }
                return true;

        }
        return super.onTouchEvent(event);
    }

    //显示数量器
    private void showCounter() {
        final ValueAnimator upAnim = ValueAnimator.ofFloat(1, 0).setDuration(300);
        upAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (float)animation.getAnimatedValue();
                invalidate();
            }
        });

        ValueAnimator downAnim = ValueAnimator.ofFloat(0,1).setDuration(300);
        downAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (float) animation.getAnimatedValue();
                if (progress == 1){
                    isHint =false;
                    upAnim.start();
                }
                invalidate();
            }
        });
        downAnim.start();

    }

    public void increase(){
        if (mQuantity<99){
            mQuantity++;
        }
        invalidate();
    }
    public void decrease(){
        if (mQuantity>1){
            mQuantity--;
            invalidate();
        }else{
            mQuantity = 0;
            shrink();
        }
    }

    private void shrink() {
        final ValueAnimator downAnim = ValueAnimator.ofFloat(1, 0).setDuration(300);
        downAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (float) animation.getAnimatedValue();
                invalidate();
            }
        });


        ValueAnimator leftCircleAnim = ValueAnimator.ofFloat(0, 1)
                .setDuration(300);
        leftCircleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (float) animation.getAnimatedValue();
                if (progress == 1){
                    isHint = true;
                    downAnim.start();
                }
                invalidate();
            }
        });
        leftCircleAnim.start();
    }

    public int getQuantity(){
        if (isHint) return 0;
        return mQuantity;
    }

    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public void setQuantityChangedListener(QuantityChangedListener listener){
        this.mQuantityChangedListener = listener;
    }


    interface QuantityChangedListener{
        void quantityChanged(SubCartView subCartView, int quantity, boolean isIncrease);
    }



}
