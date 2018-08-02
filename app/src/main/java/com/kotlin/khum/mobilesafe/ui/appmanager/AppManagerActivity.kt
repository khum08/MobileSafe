package com.kotlin.khum.mobilesafe.ui.appmanager

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import com.kotlin.khum.mobilesafe.util.StatusBarUtil

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/19
 *     desc   : 软件管理
 * </pre>
 */
class AppManagerActivity:BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context){
            context.startActivity(Intent(context,AppManagerActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setColor(this, Color.RED)
    }

    override fun initView() {
    }

    override fun attachLayoutRes(): Int = R.layout.activity_appmanager
}