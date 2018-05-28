package com.kotlin.khum.mobilesafe.ui.guard

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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
class GuardActivity : BaseActivity() {
    var defaultStartIndex = 0
    var startIndex = defaultStartIndex
    lateinit var guardAdapter: GuardAdapter

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
        val list = BlackNumberDao.getInstance(this).query(startIndex, 10)
        blackList.addAll(list)
        startIndex += 10
        guardAdapter = GuardAdapter(this, blackList)
        recycler_view.adapter = guardAdapter

        fab.setOnClickListener(View.OnClickListener { showAddDialog() })
    }

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
        guardAdapter.notifyDataSetChanged()
    }


}
