package com.kotlin.khum.mobilesafe.ui.imageloader;

import android.view.View;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/27
 *     desc   :
 * </pre>
 */
public class ImageLoaderActivity extends BaseActivity {


    @Override
    protected void initView() {
        findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_image_loader;
    }
}
