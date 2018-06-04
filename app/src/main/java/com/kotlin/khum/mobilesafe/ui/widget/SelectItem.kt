package com.kotlin.khum.mobilesafe.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.kotlin.khum.mobilesafe.R

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/4
 *     desc   :
 * </pre>
 */
class SelectItem(context:Context ,var attrs:AttributeSet? ,defStyleAttr: Int) : RelativeLayout(context,attrs,defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet):this(context,attrs,0)

    constructor(context: Context):this(context,null,0)

    init {
        initView()
    }
    lateinit var tvTop: TextView
    lateinit var tvBottom: TextView
    fun initView(){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SelectItem)
        val topText = typedArray.getText(R.styleable.SelectItem_selectTopText)
        val bottomText = typedArray.getText(R.styleable.SelectItem_selectBottomText)

        val view = LayoutInflater.from(context).inflate(R.layout.item_select, this)
        tvTop = view.findViewById<TextView>(R.id.tv_top)
        tvBottom = view.findViewById<TextView>(R.id.tv_bottom)
        tvTop.setText(topText)
        tvBottom.setText(bottomText)

        typedArray.recycle()
    }

    fun setBottom(bottomText:String){
        tvBottom.setText(bottomText)
    }

}







