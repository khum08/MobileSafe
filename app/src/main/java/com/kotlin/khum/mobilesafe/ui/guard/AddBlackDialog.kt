package com.kotlin.khum.mobilesafe.ui.guard

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.khum.mobilesafe.R
import kotlinx.android.synthetic.main.dialog_black.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   :
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
        })
        tv_cancel.setOnClickListener(View.OnClickListener { this.dismiss() })

    }
}