package com.kotlin.khum.mobilesafe.animator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/5
 *     desc   :
 * </pre>
 */
public class ProgressActivity extends BaseActivity {

    public static void starter(Context context){
        context.startActivity(new Intent(context, ProgressActivity.class));
    }

    @Override
    protected void initView() {
        ProgressView pv = findViewById(R.id.pv);
        pv.doAnimation(0.62f);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(pv, "progress", 0.62f).setDuration(2000);
                animator.setInterpolator(new BounceInterpolator());
                animator.start();
            }
        });

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_progress;
    }
}
