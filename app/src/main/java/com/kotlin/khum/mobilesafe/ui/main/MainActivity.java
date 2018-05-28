package com.kotlin.khum.mobilesafe.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;
import com.kotlin.khum.mobilesafe.ui.guard.GuardActivity;
import com.kotlin.khum.mobilesafe.ui.setting.SettingActivity;

public class MainActivity extends BaseActivity {

    private RecyclerView recycler_view;
    private TextView tv_ad;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        findView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        tv_ad.setText(R.string.ad);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recycler_view.setLayoutManager(layoutManager);
        MainAdapter adapter = new MainAdapter(this);
        recycler_view.setAdapter(adapter);

    }

    //此方法对应itemview根布局中onclink属性
    public void onItemClick(View view){
        int position = recycler_view.getChildAdapterPosition(view);
        switch (position){
            case 0:
                break;
            case 1:
                GuardActivity.start(this);
                break;
            case 8:
                SettingActivity.start(this);
                break;
            default:
                Toast.makeText(this,"click position="+recycler_view.getChildAdapterPosition(view),Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void findView() {
        recycler_view = findViewById(R.id.recycler_view);
        tv_ad= findViewById(R.id.tv_ad);
    }


}
