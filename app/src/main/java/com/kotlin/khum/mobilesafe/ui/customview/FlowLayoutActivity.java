package com.kotlin.khum.mobilesafe.ui.customview;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/6
 *     desc   :
 * </pre>
 */
public class FlowLayoutActivity extends BaseActivity {

    String[] data = {"美国","加拿大","日本","卢森堡","法国",
                    "意大利","澳大利亚","荷兰","英国","荷兰",
                    "比利时","德国","丹麦"};

    public static void starter(Context context){
        context.startActivity(new Intent(context, FlowLayoutActivity.class));
    }

    @Override
    protected void initView() {
        FlowLayout flowLayout = findViewById(R.id.flowlayout);
        flowLayout.addChildren(R.layout.view_flow, data)
                .setOnChildClickListener(new FlowLayout.OnChildClickListener() {
                    @Override
                    public void OnClick(int position, String item) {
                        Toast.makeText(FlowLayoutActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_flowlayout;
    }


}
