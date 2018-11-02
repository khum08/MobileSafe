package com.kotlin.khum.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/7
 *     desc   :
 * </pre>
 */
public class RemoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private AddAidl.Stub binder = new AddAidl.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    };
}
