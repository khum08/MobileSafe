package com.kotlin.khum.mobilesafe.ui.guard

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.khum.mobilesafe.R

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/25
 *     desc   :
 * </pre>
 */
class GuardAdapter(context:Context): RecyclerView.Adapter<GuardAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_black,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_phone?.text= "17612159408"
        holder.tv_intercept?.text = "拦截电话"
    }

    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

        var tv_phone:TextView ?= null
        var tv_intercept:TextView ?= null
        init {
            tv_phone = view.findViewById(R.id.tv_phone)
            tv_intercept = view.findViewById(R.id.tv_intercept)
        }
    }
}