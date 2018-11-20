package com.kotlin.khum.mobilesafe.ui.imageloader;

import android.view.View;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/27
 *     desc   :
 * </pre>
 */
public class ImageLoaderActivity extends BaseActivity {

    private TextView mTextView;
    String[] data = {"山大", "北大", "清华", "复旦"};
    int status = 0;

    @Override
    protected void initView() {
        findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventTest(data[status]));
                status++;
                if (status>3) status=0;
            }
        });
        mTextView = findViewById(R.id.tv_test2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Subscribe
    public void onEvent(EventTest test){
        mTextView.setText(test.test);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventSticky(EventTest test){
        mTextView.setText(test.test);
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_image_loader;
    }
}
