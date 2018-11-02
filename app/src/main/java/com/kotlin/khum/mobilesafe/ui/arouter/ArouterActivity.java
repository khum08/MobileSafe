package com.kotlin.khum.mobilesafe.ui.arouter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/26
 *     desc   :
 * </pre>
 */
public class ArouterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);
        TextView tv_test = findViewById(R.id.tv_test);
    }

}
