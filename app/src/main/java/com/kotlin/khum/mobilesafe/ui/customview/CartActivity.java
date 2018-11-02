package com.kotlin.khum.mobilesafe.ui.customview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class CartActivity extends BaseActivity {

    public static void launch(Context context){
        context.startActivity(new Intent(context, CartActivity.class));
    }

    @Override
    protected void initView() {
        final SubCartView subCartView = findViewById(R.id.scv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "数量为："+subCartView.getQuantity(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_cart;
    }
}
