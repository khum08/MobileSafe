package com.kotlin.khum.mobilesafe.ui.guard

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.db.domain.BlackNumber

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/29
 *     desc   :
 * </pre>
 */
class Guard2Adapter(layoutResId: Int, data: MutableList<BlackNumber>?) : BaseQuickAdapter<BlackNumber, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: BlackNumber?) {
        helper?.setText(R.id.tv_phone,item?.phone)
                ?.setText(R.id.tv_intercept,when(item?.intercept){
                    0 -> "拦截电话"
                    1 -> "拦截短信"
                    2 -> "拦截所有"
                    else -> "其他"
                })

    }

}