package com.kotlin.khum.mobilesafe.ui.appmanager

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.khum.mobilesafe.R

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/3
 *     desc   :
 * </pre>
 */
class SearchLeftAdapter(layoutResId: Int, data: MutableList<SearchItem>?) :
        BaseQuickAdapter<SearchItem, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: SearchItem?) {
        helper?.setText(R.id.tv_search_item,item?.itemName)
                ?.addOnClickListener(R.id.tv_search_item)


    }
}