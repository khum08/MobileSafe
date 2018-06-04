package com.kotlin.khum.mobilesafe.ui.guard

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.db.dao.BlackNumberDao
import com.kotlin.khum.mobilesafe.db.domain.BlackNumber
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.activity_guard.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/25
 *     desc   :
 * </pre>
 */
class GuardActivity : BaseActivity() ,BaseQuickAdapter.RequestLoadMoreListener{
    var defaultStartIndex = 0
    var startIndex = defaultStartIndex
//    lateinit var guardAdapter: GuardAdapter
    lateinit var guard2Adapter: Guard2Adapter
    private lateinit var list: MutableList<BlackNumber>
    private var tableCount: Int = 0

    var blackList = ArrayList<BlackNumber>()

    companion object {
        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, GuardActivity::class.java))
        }
    }

    override fun attachLayoutRes(): Int = R.layout.activity_guard

    override fun initView() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        tableCount = BlackNumberDao.getInstance(this).queryTableCount()
        //分页查询
        queryDatabase()
        initAdapter(blackList)
        //添加黑名单
        fab.setOnClickListener{ showAddDialog() }

    }

    private fun initAdapter(list: MutableList<BlackNumber>) {
        guard2Adapter = Guard2Adapter(R.layout.item_black, list)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = linearLayoutManager
        guard2Adapter.setOnLoadMoreListener(this,recycler_view)
        recycler_view.adapter = guard2Adapter
    }

    private fun queryDatabase(){
        list = BlackNumberDao.getInstance(this).query(startIndex, 10)
        blackList.addAll(list)
        startIndex += 10
    }

    //下拉加载更多
    override fun onLoadMoreRequested() {
        if (tableCount <= startIndex){
            guard2Adapter.loadMoreEnd(false)
        }else{
            queryDatabase()
            guard2Adapter.loadMoreComplete()
            notifyDataChanged()
        }
    }

    //显示添加对话框
    private fun showAddDialog() {
        val addBlackDialog = AddBlackDialog(this, R.style.Dialog_black)
        addBlackDialog.show()
    }

    //注册EventBus
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun handleAddBlackEvent(blackNumber: BlackNumber) {
        blackList.add(0, blackNumber)
        notifyDataChanged()
    }

    private fun notifyDataChanged(){
        guard2Adapter.notifyDataSetChanged()
    }


}
