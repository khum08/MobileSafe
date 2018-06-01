package com.kotlin.khum.mobilesafe.ui.guard

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.provider.ContactsContract
import android.support.v7.widget.LinearLayoutManager
import android.widget.RadioGroup
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import com.kotlin.khum.mobilesafe.util.ToastUtils
import kotlinx.android.synthetic.main.activity_contact.*


/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/31
 *     desc   : 获取联系人的页面
 * </pre>
 */
class ContactActivity : BaseActivity(),BaseQuickAdapter.RequestLoadMoreListener {

    private val uri1: Uri = ContactsContract.RawContacts.CONTENT_URI
    private val uriPhone: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    private val uriEmail: Uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI
    private var contactList: MutableList<MutableMap<String, String>> = mutableListOf()
    lateinit var contactAdapter: ContactAdapter


    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
//            showProgressDialog(false)
            ToastUtils.showShortToast("handleMessage")
            when (msg?.what) {
                1 -> {
                    showContactList(contactList)
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, ContactActivity::class.java))
//            context.startActivityForResult(Intent(context,ContactActivity::class.java),1)
        }
    }

    override fun initView() {
        //设置radio_group的监听
        radio_group.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.get_contact -> {
                        getContact()
//                        showProgressDialog(true)
                    }
                    R.id.jump_contact -> jumpContact()
                }
            }
        })
    }

    override fun attachLayoutRes() = R.layout.activity_contact

    /**
     * 通过ContentProvider获取联系人
     */
    fun getContact() {
//        此处有一个不明原因的bug
//        showProgressDialog(true)
//        Thread {
//            Runnable {
//                getData()
                handler.sendEmptyMessage(1)
//            }
//        }.start()
        getData()
        showContactList(contactList)
    }

    //展示联系人信息
    private fun showContactList(contactList: MutableList<MutableMap<String, String>>) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        contact_recycler_view.layoutManager = layoutManager
        contactAdapter = ContactAdapter(R.layout.item_contact, contactList)
        with(contactAdapter) {
            //            openLoadAnimation(ScaleInAnimation(.6f))
            setOnLoadMoreListener(this@ContactActivity,contact_recycler_view)
            setPreLoadNumber(4)//提前加载更多
            isFirstOnly(false)
        }
        contact_recycler_view.adapter = contactAdapter
    }

    /**
     * 跳转联系人列表页面
     */
    fun jumpContact() {
        val uri = Uri.parse("content://contacts/people")
        val intent = Intent(Intent.ACTION_PICK, uri)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==1 && resultCode == Activity.RESULT_OK){
            Toast.makeText(this,data.toString(),Toast.LENGTH_SHORT).show()
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private var mProgressDialog: ProgressDialog? = null
    fun showProgressDialog(show: Boolean) {
        if(mProgressDialog!=null){
            if (show) {
                mProgressDialog?.show()
            } else {
                mProgressDialog?.dismiss()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog?.setMessage("正在加载中...")
        mProgressDialog?.setCanceledOnTouchOutside(false)
    }

    var currentCount = 0
    lateinit var resolver: ContentResolver
    fun getData(){
        contactList = mutableListOf<MutableMap<String, String>>()
        resolver = contentResolver
        queryDatabase(resolver,currentCount,15)
        currentCount += 15
    }

    //下拉加载更多
    override fun onLoadMoreRequested() {
        queryDatabase(resolver,currentCount,15)
        currentCount += 15
        contactAdapter.notifyDataSetChanged()
        contactAdapter.loadMoreComplete()
    }

    //查询数据库
    private fun queryDatabase(resolver: ContentResolver,startIndex: Int,pageCount:Int) {
        val cursor = resolver.query(uri1, arrayOf("_id", "display_name"),
                null,null, "_id limit "+startIndex+","+pageCount)
        cursor.let {
            while (it.moveToNext()) {
                //存放每个联系人的信息
                val map = mutableMapOf<String, String>()
                val _id = cursor.getString(0)
                val display_name = cursor.getString(1)
                map["_id"] = _id
                map["display_name"] = display_name

                //查询手机号
                val data = resolver.query(uriPhone, arrayOf("data1"), "raw_contact_id = ?", arrayOf(_id), null)
                data.let {
                    while (it.moveToNext()) {
                        val phone = it.getString(0)
                        map.put("phone", phone)
                    }
                }

                //查询邮箱地址
                val data2 = resolver.query(uriEmail, arrayOf("data1"), "raw_contact_id = ?", arrayOf(_id), null)
                data2.let {
                    while (it.moveToNext()) {
                        val email = it.getString(0)
                        map["email"] = email
                    }
                }

                data.close()
                data2.close()
                contactList.add(map)
            }
            cursor.close()
        }
    }
}

