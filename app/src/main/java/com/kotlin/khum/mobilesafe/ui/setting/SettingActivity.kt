package com.kotlin.khum.mobilesafe.ui.setting

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import com.kotlin.khum.mobilesafe.service.BlackNumberService
import com.kotlin.khum.mobilesafe.util.serviceIsRunning
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.common_title.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/24
 *     desc   : 设置页面
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
        //自动更新
        updateSeg()
        //归属地显示
        addressShowSeg()
        //归属地提示风格
        addressStyle()
        //归属地提示位置
        addressLocation()
        //拦截黑名单
        interceptSeg()
    }

    //归属地提示位置
    fun addressLocation(){
        address_location.setOnClickListener{
            val dialog = LocationDialog(this)
            dialog.show()
        }
    }

    //归属地提示风格
    fun addressStyle(){
        address_style.setOnClickListener{
            Toast.makeText(this,"click here",Toast.LENGTH_SHORT).show()
        }
    }

    //归属地显示
    fun addressShowSeg(){
        show_address.setOnClickListener{
            show_address.setItemChecked(!show_address.isChecked)
        }
    }

    //自动更新
    fun updateSeg(){
        auto_update.setOnClickListener{
            auto_update.setItemChecked(!auto_update.isChecked)
        }
    }


    //拦截黑名单
    fun interceptSeg(){
        val isRunning = serviceIsRunning(
                this,
                "com.kotlin.khum.mobilesafe.service.BlackNumberService"
        )
        intercept.setItemChecked(isRunning)
        intercept.setOnClickListener{
            intercept.setItemChecked(!intercept.isChecked)
            if(isRunning){
                //关闭服务
                stopService(Intent(this,BlackNumberService::class.java))
            }else{
                //启动服务
                startService(Intent(this, BlackNumberService::class.java))
            }
        }
    }

}