package com.kotlin.khum.mobilesafe.ui.guard

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.khum.mobilesafe.R

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/31
 *     desc   : 展示联系人列表
 * </pre>
 */
class ContactAdapter(layoutResId: Int, data: MutableList<MutableMap<String, String>>?)
    : BaseQuickAdapter<MutableMap<String, String>, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: MutableMap<String, String>?) {
        helper?.setText(R.id.tv_name,item?.get("display_name"))
                ?.setText(R.id.tv_mode,item?.get("phone"))
    }
}