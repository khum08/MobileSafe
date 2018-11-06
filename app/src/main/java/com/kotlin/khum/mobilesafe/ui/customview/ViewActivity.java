package com.kotlin.khum.mobilesafe.ui.customview;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.animator.ProgressActivity;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   : 购物车控件
 * </pre>
 */
public class ViewActivity extends BaseActivity {

    public static void launch(Context context){
        context.startActivity(new Intent(context, ViewActivity.class));
    }


    @Override
    protected void initView() {
        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartActivity.launch(ViewActivity.this);
            }
        });
        findViewById(R.id.test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressActivity.starter(ViewActivity.this);
            }
        });

        findViewById(R.id.test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlowLayoutActivity.starter(ViewActivity.this);
            }
        });

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_view;
    }
}
