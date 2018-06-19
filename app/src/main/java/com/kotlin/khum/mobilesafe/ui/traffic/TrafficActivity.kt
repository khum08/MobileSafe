package com.kotlin.khum.mobilesafe.ui.traffic

import android.content.Context
import android.content.Intent
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.common_title.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/19
 *     desc   :
 * </pre>
 */
class TrafficActivity:BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context){
            context.startActivity(Intent(context,TrafficActivity::class.java))
        }
    }

    override fun initView() {
        setSupportActionBar(tool_bar)
        tool_bar.title = "流量统计"
    }

    override fun attachLayoutRes(): Int = R.layout.activity_traffic
}