package com.kotlin.khum.mobilesafe.ui.guard

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.kotlin.khum.mobilesafe.R

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
    }
}