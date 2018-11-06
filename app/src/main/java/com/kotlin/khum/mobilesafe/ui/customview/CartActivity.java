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

    private MyCartView mCartView;
    private CartView mSubCartView;

    public static void launch(Context context){
        context.startActivity(new Intent(context, CartActivity.class));
    }

    @Override
    protected void initView() {
        mSubCartView = findViewById(R.id.scv);
        mCartView = findViewById(R.id.cv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "数量为："+ mSubCartView.getQuantity(), Toast.LENGTH_SHORT).show();
            }
        });
        mSubCartView.setQuantityChangedListener(new CartView.QuantityChangedListener() {
            @Override
            public void quantityChanged(CartView subCartView, int quantity, boolean isIncrease) {
                int q = subCartView.getQuantity();
                if (q>0 && isIncrease){
                }
            }
        });

    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_cart;
    }
}
