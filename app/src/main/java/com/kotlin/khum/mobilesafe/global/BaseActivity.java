package com.kotlin.khum.mobilesafe.global;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/22
 *     desc   :
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        initView();
    }

    protected abstract void initView();

    protected abstract int attachLayoutRes();

}
