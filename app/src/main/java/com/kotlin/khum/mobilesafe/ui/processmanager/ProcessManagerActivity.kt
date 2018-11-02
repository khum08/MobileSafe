package com.kotlin.khum.mobilesafe.ui.processmanager

import android.content.Context
import android.content.Intent
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.common_title.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/19
 *     desc   : 进程管理
 * </pre>
 */
class ProcessManagerActivity:BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context){
            context.startActivity(Intent(context,ProcessManagerActivity::class.java))
        }
    }

    override fun initView() {
        setSupportActionBar(tool_bar)
        tool_bar.title = "dialog"
        val dialog = SignInDialog.newInstance()
        dialog.show(fragmentManager,"sign_in")
    }

    override fun attachLayoutRes(): Int = R.layout.activity_processmanager
}