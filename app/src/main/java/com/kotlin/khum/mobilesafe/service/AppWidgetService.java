package com.kotlin.khum.mobilesafe.service;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.receiver.MyAppWidgetProvider;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/4
 *     desc   : 小部件创建逻辑真正处理的地方
 * </pre>
 */
public class AppWidgetService extends Service {

    private RemoteViews mRemoteViews;
    private String mTime;
    private SimpleDateFormat mSimpleDateFormat;
    private static final String TAG = "AppWidgetService";
    private Timer mTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRemoteViews = new RemoteViews(getPackageName(), R.layout.view_remote);
        mSimpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        startTimer();
    }


    private void startTimer() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateWidget();
                Log.d(TAG, "run: ");
            }
        },0,1000);
    }

    /**
     * 更新桌面小部件
     */
    private void updateWidget(){
        mTime = mSimpleDateFormat.format(System.currentTimeMillis());
        mRemoteViews.setTextViewText(R.id.tv_time,mTime);
        ComponentName componentName = new ComponentName(this, MyAppWidgetProvider.class);
        AppWidgetManager instance = AppWidgetManager.getInstance(this);
        instance.updateAppWidget(componentName,mRemoteViews);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer!=null){
            mTimer.cancel();
        }
    }
}










