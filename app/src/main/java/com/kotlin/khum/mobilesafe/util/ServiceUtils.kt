package com.kotlin.khum.mobilesafe.util

import android.app.ActivityManager
import android.content.Context
import android.text.TextUtils


/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/29
 *     desc   : 判断服务是否正在运行
 * </pre>
 */

fun serviceIsRunning(context: Context,serviceName:String)  :Boolean {
    var isRunning = false
    if (TextUtils.isEmpty(serviceName))
        isRunning =  false
    val myManager = context
            .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val runningService = myManager
            .getRunningServices(30) as ArrayList<ActivityManager.RunningServiceInfo>
    for (i in 0 until runningService.size) {
        if (runningService[i].service.className.toString() == serviceName) {
            isRunning = true
        }
    }
    return isRunning
}