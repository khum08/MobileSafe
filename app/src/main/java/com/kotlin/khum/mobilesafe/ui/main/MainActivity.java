package com.kotlin.khum.mobilesafe.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;
import com.kotlin.khum.mobilesafe.ui.aidl.AidlActivity;
import com.kotlin.khum.mobilesafe.ui.appmanager.AppManagerActivity;
import com.kotlin.khum.mobilesafe.ui.customview.ViewActivity;
import com.kotlin.khum.mobilesafe.ui.glideDemo.GlideActivity;
import com.kotlin.khum.mobilesafe.ui.guard.GuardActivity;
import com.kotlin.khum.mobilesafe.ui.home.Main2Activity;
import com.kotlin.khum.mobilesafe.ui.imageloader.EventTest;
import com.kotlin.khum.mobilesafe.ui.imageloader.ImageLoaderActivity;
import com.kotlin.khum.mobilesafe.ui.processmanager.ProcessManagerActivity;
import com.kotlin.khum.mobilesafe.ui.setting.SettingActivity;
import com.kotlin.khum.mobilesafe.ui.traffic.TrafficActivity;
import com.kotlin.khum.mobilesafe.ui.transition.TransitionActivity;

import org.greenrobot.eventbus.EventBus;


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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        EventBus.getDefault().postSticky(new EventTest("STICKY EVENT"));
    }

    private void initRecyclerView() {
        tv_ad.setText(R.string.ad);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recycler_view.setLayoutManager(layoutManager);
        MainAdapter adapter = new MainAdapter(this);
        recycler_view.setAdapter(adapter);
        
    }

    //此方法对应itemView根布局中onclick属性
    public void onItemClick(View view){
        int position = recycler_view.getChildAdapterPosition(view);
        switch (position){
            case 0:
                break;
            case 1:
                GuardActivity.start(this);
                break;
            case 2:
                AppManagerActivity.start(this);
                break;
            case 3:
                ProcessManagerActivity.start(this);
                break;
            case 4:
                TrafficActivity.start(this);
                break;
            case 5:
                startActivity(new Intent(this, TransitionActivity.class));
                break;
            case 6:
                break;
            case 7:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case 8:
                SettingActivity.start(this);
                break;
            case 9:
                AidlActivity.start(this);
                break;
            case 10:
                startActivity(new Intent(this, ImageLoaderActivity.class));
                break;
            case 11:
                ViewActivity.launch(this);
                break;
            case 12:
                startActivity(new Intent(this, GlideActivity.class));
                break;
            case 13:
                showDialog();
                break;
            default:
                Toast.makeText(this,"click position="+recycler_view.getChildAdapterPosition(view),Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setMessage("你是猪")
                .setTitle("Title")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    private void findView() {
        recycler_view = findViewById(R.id.recycler_view);
        tv_ad= findViewById(R.id.tv_ad);
    }


}
