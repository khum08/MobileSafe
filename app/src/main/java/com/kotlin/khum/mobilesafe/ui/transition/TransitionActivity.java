package com.kotlin.khum.mobilesafe.ui.transition;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.View;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : yuanzhenkun
 *     time   : 2018/11/11
 *     desc   :
 * </pre>
 */
public class TransitionActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
    }

    @Override
    protected void initView() {
        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionActivity.this.startActivity(new Intent(TransitionActivity.this, TransitionTest1Activity.class));
            }
        });
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_transition;
    }
}
