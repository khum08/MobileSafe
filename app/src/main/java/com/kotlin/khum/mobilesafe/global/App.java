package com.kotlin.khum.mobilesafe.global;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * <pre>
 *     author : yuanzhenkun
 *     time   : 2018/8/26
 *     desc   :
 * </pre>
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
    }

    private void initArouter() {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
