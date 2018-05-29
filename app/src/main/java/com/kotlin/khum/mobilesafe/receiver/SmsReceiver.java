package com.kotlin.khum.mobilesafe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.kotlin.khum.mobilesafe.db.dao.BlackNumberDao;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/29
 *     desc   : 拦截短信的广播
 * </pre>
 */
public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] objects = (Object[]) bundle.get("pdus");
            for (Object object : objects) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) object);
                String phone = sms.getOriginatingAddress();
                BlackNumberDao dao = BlackNumberDao.getInstance(context);
                int mode =  dao.queryModeViaPhone(phone);
                if (mode == 1 || mode == 3) {
                    abortBroadcast();
                }
            }
        }
    }
}
