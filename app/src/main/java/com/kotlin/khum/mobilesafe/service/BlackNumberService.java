package com.kotlin.khum.mobilesafe.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kotlin.khum.mobilesafe.receiver.SmsReceiver;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/29
 *     desc   : 黑名单监听的服务
 * </pre>
 */
public class BlackNumberService extends Service {

    private IntentFilter mIntentFilter;
    private SmsReceiver mSmsReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initInterceptSMS();
    }

    /**
     * 拦截短信 动态注册广播接受者
     */
    private void initInterceptSMS() {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        mIntentFilter.setPriority(1000);
        mSmsReceiver = new SmsReceiver();
        registerReceiver(mSmsReceiver,mIntentFilter);
    }

    /**
     * 反注册广播接受者
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mSmsReceiver!=null){
            unregisterReceiver(mSmsReceiver);
        }
    }
}




