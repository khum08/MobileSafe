package com.kotlin.khum.mobilesafe.ui.guard

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.db.dao.BlackNumberDao
import com.kotlin.khum.mobilesafe.db.domain.BlackNumber
import kotlinx.android.synthetic.main.dialog_black.*
import org.greenrobot.eventbus.EventBus

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   : 添加黑名单的dialog (自定义这个dialog,方便设置style)
 * </pre>
 */
class AddBlackDialog(context: Context?, themeResId: Int) : Dialog(context, themeResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_black)
        tv_confirm.setOnClickListener(View.OnClickListener {
            val phone = tv_input_phone.text.toString()
            if (phone.length!=11){
                Toast.makeText(context,"请输入正确的手机号",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            val radioButtonId = radio_group.checkedRadioButtonId
            if(radioButtonId==-1){
                Toast.makeText(context,"请选择拦截方式",Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val dao = BlackNumberDao.getInstance(context)
            val interceptMode = when(radioButtonId){
                R.id.intercept_phone -> 0
                R.id.intercept_msg -> 1
                R.id.intercept_all -> 2
                else -> 3
            }
            val blackNumber = BlackNumber(phone,interceptMode)
            val success = dao.insert(phone, interceptMode)
            if(success){
                this.dismiss()
            }else{
                Toast.makeText(context,"添加黑名单失败",Toast.LENGTH_LONG).show()
            }
            //发送一个通知给页面刷新数据
            EventBus.getDefault().post(blackNumber)
        })
        tv_cancel.setOnClickListener{ this.dismiss() }
    }
}


