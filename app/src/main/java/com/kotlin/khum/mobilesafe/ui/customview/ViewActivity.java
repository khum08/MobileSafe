package com.kotlin.khum.mobilesafe.ui.customview;

import android.view.View;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class ViewActivity extends BaseActivity {
    @Override
    protected void initView() {
        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_view;
    }
}
