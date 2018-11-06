package com.kotlin.khum.mobilesafe.util;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * <pre>
 *     author : yuanzhenkun
 *     time   : 2018/11/5
 *     desc   :
 * </pre>
 */

public class FirstInitUtils{

    public static RefWatcher init(Application context){
        return initLeakCanary(context);
    }

    //初始化内存泄漏检验
    private static RefWatcher initLeakCanary(Application context){
        if (LeakCanary.isInAnalyzerProcess(context)) {
            return null;
        }
        return LeakCanary.install(context);
    }
}
