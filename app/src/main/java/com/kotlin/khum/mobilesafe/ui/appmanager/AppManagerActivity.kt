package com.kotlin.khum.mobilesafe.ui.appmanager

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import com.kotlin.khum.mobilesafe.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_appmanager.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/6/19
 *     desc   : 软件管理
 * </pre>
 */
class AppManagerActivity:BaseActivity() {

    private lateinit var adapter: SearchLeftAdapter
    var lastPosition:Int = -1

    companion object {
        @JvmStatic
        fun start(context: Context){
            context.startActivity(Intent(context,AppManagerActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setColor(this, Color.RED)
    }

    override fun initView() {
        tv_search.setOnClickListener {
            Toast.makeText(this,"go to search page",Toast.LENGTH_SHORT).show()
        }
        initAdapter()
    }

    override fun attachLayoutRes(): Int = R.layout.activity_appmanager

    private fun initAdapter(){
        val data1 = SearchItem("运动","")
        val data2 = SearchItem("服装","")
        val data3 = SearchItem("图书","")
        val data4 = SearchItem("运动","")
        val data5 = SearchItem("鞋类","")
        val data6 = SearchItem("淘宝","")
        val data7 = SearchItem("京东","")
        val data8 = SearchItem("天猫","")
        val data = mutableListOf(data1,data2,data3,data4,data5,data6,data7,data8,
                data1,data2,data3,data4,data5,data6,data7,data8)
        val lm = LinearLayoutManager(this)
        rv_left.layoutManager = lm
        adapter = SearchLeftAdapter(R.layout.item_search,data)
        rv_left.adapter = adapter
        adapter.setOnItemChildClickListener { adapter, view, position ->

        }

    }
}