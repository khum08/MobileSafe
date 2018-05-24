package com.kotlin.khum.mobilesafe.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/24
 *     desc   :
 * </pre>
 */
public class CheckableItem extends RelativeLayout {

    private static final String NAME = "http://schemas.khum";
    private String mTopText;
    private String mBottomText;
    private TextView mTvTop;
    private TextView mTvBottom;
    private CheckBox mCheckBox;

    public CheckableItem(Context context) {
        this(context,null);
    }

    public CheckableItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CheckableItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CheckableItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs) {
//        mTopText = attrs.getAttributeValue(NAME, "topText");
//        mBottomText = attrs.getAttributeValue(NAME, "bottomText");

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CheckableItem);
        mTopText = typedArray.getText(R.styleable.CheckableItem_topText).toString();
        mBottomText = typedArray.getText(R.styleable.CheckableItem_bottomText).toString();

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_checkable, this);
        mTvTop = findViewById(R.id.tv_top);
        mTvBottom = findViewById(R.id.tv_bottom);
        mCheckBox = findViewById(R.id.checkbox);

        mTvTop.setText(mTopText);
        mTvBottom.setText(mBottomText);
        typedArray.recycle();//清理资源，回收资源，为了防止下一次使用的时候造成影响
    }

    public void setBottomText(String text){
        mTvBottom.setText(text);
    }

    public void setItemChecked(boolean checked){
        mCheckBox.setChecked(checked);
    }

    public boolean isChecked(){
        return mCheckBox.isChecked();
    }




}
