package com.kotlin.khum.mobilesafe.ui.aidl

import android.content.Context
import android.content.Intent
import android.graphics.Color
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import com.kotlin.khum.mobilesafe.util.StatusBarUtil

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/7
 *     desc   :
 * </pre>
 */
class AidlActivity : BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, AidlActivity::class.java))
        }
    }

//    lateinit var remoteService: AddAidl

    override fun initView() {
        StatusBarUtil.setColor(this, Color.GREEN)
//        val intent = Intent(this, remoteService::class.java)
//        bindService(intent, object : ServiceConnection {
//            override fun onServiceDisconnected(name: ComponentName?) {
//            }
//
//            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//                remoteService = AddAidl.Stub.asInterface(service)
//            }
//        }, Service.BIND_AUTO_CREATE)
//
//        calculate()
    }

//    private fun calculate() {
//        var num1 = Integer.parseInt(et_num1.text.toString())
//        var num2 = Integer.parseInt(et_num2.text.toString())
//        btn_sure.setOnClickListener {
//            var result = remoteService.add(num1,num2)
//            et_result.setText(result.toString())
//        }
//    }

    override fun attachLayoutRes(): Int = R.layout.activity_aidl


}