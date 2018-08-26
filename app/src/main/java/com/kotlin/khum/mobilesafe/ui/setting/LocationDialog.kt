package com.kotlin.khum.mobilesafe.ui.setting

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.kotlin.khum.mobilesafe.R
import kotlinx.android.synthetic.main.dialog_location.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/4
 *     desc   :
 * </pre>
 */
class LocationDialog(context: Context?, themeResId: Int) : Dialog(context, themeResId) {

    constructor(context: Context?):this(context,R.style.Dialog_location)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_location)
        btn_location.setOnClickListener{
            Toast.makeText(context,"click here",Toast.LENGTH_SHORT).show()
        }
        btn_location.setOnTouchListener(object :View.OnTouchListener{
            var startX :Int = 0
            var startY :Int = 0
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when(event?.action){
                    MotionEvent.ACTION_DOWN -> {
                        startX = event.rawX.toInt()
                        startY = event.rawY.toInt()
                    }
                    MotionEvent.ACTION_MOVE -> {
                        val endX = event.rawX.toInt()
                        val endY = event.rawY.toInt()
                        val dx = endX - startX
                        val dy = endY - startY

                        val top = btn_location.top +dy
                        val bottom = btn_location.bottom + dy
                        val left = btn_location.left +dx
                        val right = btn_location.right + dx
                        btn_location.layout(left,top,right,bottom)
                        startX = endX
                        startY = endY
                    }
                    MotionEvent.ACTION_UP -> {
                    }
                    MotionEvent.ACTION_CANCEL,MotionEvent.ACTION_OUTSIDE -> {

                    }
                }
                return false
            }
        })
    }


    override fun show() {
        super.show()
        val layoutParams = window.attributes
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT
        window.decorView.setPadding(0,0,0,0)
        window.attributes = layoutParams
    }
}