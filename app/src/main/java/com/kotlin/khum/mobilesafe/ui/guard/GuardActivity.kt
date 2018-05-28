package com.kotlin.khum.mobilesafe.ui.guard

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.activity_guard.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/25
 *     desc   :
 * </pre>
 */
class GuardActivity:BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context:Context){
            context.startActivity(Intent(context,GuardActivity::class.java))
        }
    }
    override fun attachLayoutRes(): Int = R.layout.activity_guard

    override fun initView() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        val guardAdapter = GuardAdapter(this)
        recycler_view.adapter = guardAdapter
    }



}
