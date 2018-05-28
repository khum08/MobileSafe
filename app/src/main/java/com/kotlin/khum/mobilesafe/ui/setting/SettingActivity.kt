package com.kotlin.khum.mobilesafe.ui.setting

import android.content.Context
import android.content.Intent
import android.view.View
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.common_title.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/24
 *     desc   :
 * </pre>
 */
class SettingActivity:BaseActivity(){

    companion object {
        @JvmStatic
        fun start(context: Context){
            context.startActivity(Intent(context,SettingActivity::class.java))
        }
    }
    override fun attachLayoutRes(): Int = R.layout.activity_setting

    override fun initView() {
        tool_bar.title = "设置"
        auto_update.setOnClickListener(View.OnClickListener {
            if (auto_update.isChecked){
                auto_update.setBottomText("自动更新关闭")
                auto_update.setItemChecked(false)
            }else{
                auto_update.setBottomText("自动更新已开启")
                auto_update.setItemChecked(true)
            }
        })
    }
}