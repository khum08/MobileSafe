package com.kotlin.khum.mobilesafe.ui.customview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;

/**
 * 使用别人开源的代码当然容易，自己能手写出来才是硬道理
 */
public class FlowLayout extends ViewGroup {

    private OnChildClickListener listener;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    SparseIntArray array = new SparseIntArray();//记录第几个view所在第几行，行数从1开始

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //递归的测量子控件，以确定自身的宽高。
        //注意让自定义的控件支持margin和padding
        array.clear();
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthMax = widthSize - getPaddingLeft() - getPaddingRight();

        int childCount = getChildCount();
        View child; //子控件的引用
        MarginLayoutParams layoutParams;
        int childWidth; //子控件的宽度
        int childHeight;//子控件的高度
        int lineWidthSum = 0; //每一行的宽度之和
        int lineWidthMax = 0; //宽度的最大值
        int line = 1;
        int lineHeightSum = getPaddingTop() + getPaddingBottom();//总高度
        int currentLineHeightMax=0;
        for (int i= 0; i < childCount; i++) {
            child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            layoutParams = (MarginLayoutParams)child.getLayoutParams();
            childWidth = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            childHeight = child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            currentLineHeightMax = Math.max(currentLineHeightMax, childHeight); //计算每一行高度的最大值
            if(i==0) {
                lineHeightSum =+ currentLineHeightMax;
            }
            if (lineWidthSum +childWidth >= widthMax){
                //该换行了
                array.put(i, ++line);
                lineWidthSum = childWidth;
                lineHeightSum += currentLineHeightMax;
            }else{
                array.put(i, line);
                lineWidthSum += childWidth;
            }
            lineWidthMax = Math.max(lineWidthSum, lineWidthMax);
        }
        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY? widthSize: widthMax,
                heightMode == MeasureSpec.EXACTLY? heightSize: lineHeightSum);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        View child;
        Integer line;
        int startL = getPaddingLeft();
        int startT = getPaddingTop();
        int nextT = startT;
        int width;//当前子view的宽度
        int height;//当前子View的高度
        int currentLine = 1;
        int lineHeightMax = 0; //每一行高度的最大值
        MarginLayoutParams layoutParams;
        for (int i=0; i<childCount; i++){
            child = getChildAt(i);
            layoutParams = (MarginLayoutParams) child.getLayoutParams();
            width = child.getMeasuredWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
            height = child.getMeasuredHeight()+layoutParams.topMargin+layoutParams.bottomMargin;
            line = array.get(i);
            if (currentLine == line){
                child.layout(startL, startT, startL+width, startT+height);
                startL += width;
                lineHeightMax = Math.max(height, lineHeightMax);
            }else{//换行
                nextT += lineHeightMax;
                startL = getPaddingLeft();
                startT = nextT;
                currentLine = line;
                child.layout(startL, startT, startL+width, startT+height);
                startL += width;
            }
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    public FlowLayout addChildren (@LayoutRes int resId, String[] data) {
        View view;
        TextView textView;
        for(int i = 0; i < data.length; i++){
            int temp = i;
            view = LayoutInflater.from(getContext()).inflate(resId, this, false);
            textView = view.findViewById(R.id.tv_flow);
            textView.setOnClickListener(v -> {
                if (listener!=null)
                    listener.OnClick(temp, data[temp]);
            });
            textView.setText(data[i]);
            this.addView(view);
        }
        return this;
    }

    public void setOnChildClickListener(OnChildClickListener listener){
        this.listener = listener;
    }

    interface OnChildClickListener {
        void OnClick(int position, String item);
    }
}
