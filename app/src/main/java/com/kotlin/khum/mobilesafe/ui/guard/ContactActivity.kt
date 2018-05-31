package com.kotlin.khum.mobilesafe.ui.guard

import android.app.ProgressDialog
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
import com.kotlin.khum.mobilesafe.R
import com.kotlin.khum.mobilesafe.global.BaseActivity
import kotlinx.android.synthetic.main.activity_contact.*

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/31
 *     desc   :
 * </pre>
 */
class ContactActivity : BaseActivity() {

    private val uri1: Uri = ContactsContract.RawContacts.CONTENT_URI
    private val uriPhone: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    private val uriEmail: Uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI

    val handler = object :Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message?) {
            when(msg?.what){
                1 -> {
                    val data = msg.obj
                    showContactList(data as MutableList<MutableMap<String, String>>)
                    showProgressDialog(false)
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
                    R.id.get_contact -> getContact()
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
        showProgressDialog(true)
        //存放所有人的list
        Thread{
            kotlin.run {
                val contactList = mutableListOf<MutableMap<String,String>>()
                val resolver = contentResolver
                val cursor = resolver.query(uri1, arrayOf("_id", "display_name"), null, null, null)
                cursor.let {
                    while (it.moveToNext()){
                        //存放每个联系人的信息
                        val map = mutableMapOf<String,String>()
                        val _id = cursor.getString(0)
                        val display_name = cursor.getString(1)
                        map["_id"] = _id
                        map["display_name"] = display_name

                        //查询手机号
                        val data = resolver.query(uriPhone, arrayOf("data1"), "raw_contact_id = ?", arrayOf(_id), null)
                        data.let {
                            while (it.moveToNext()){
                                val phone = it.getString(0)
                                map.put("phone",phone)
                            }
                        }

                        //查询邮箱地址
                        val data2 = resolver.query(uriEmail, arrayOf("data1"),"raw_contact_id = ?", arrayOf(_id),null)
                        data2.let {
                            while (it.moveToNext()){
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
                val msg = Message.obtain()
                msg.obj = contactList
                msg.what = 1
                handler.sendMessage(msg)
            }
        }.run()
    }

    //展示联系人信息
    private fun showContactList(contactList: MutableList<MutableMap<String, String>>) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        contact_recycler_view.layoutManager = layoutManager
        val contactAdapter = ContactAdapter(R.layout.item_contact, contactList)

        with(contactAdapter){
//            openLoadAnimation(ScaleInAnimation(.6f))
            isFirstOnly(false)
        }
        contact_recycler_view.adapter = contactAdapter

    }

    /**
     * 跳转联系人列表页面
     */
    fun jumpContact() {

    }

    var mProgressDialog:ProgressDialog ?=null
    fun showProgressDialog(show :Boolean){
        if(mProgressDialog!= null && show){
            mProgressDialog?.show()
        }else{
            mProgressDialog?.dismiss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog?.setMessage("正在加载中...")
        mProgressDialog?.setCanceledOnTouchOutside(false)
    }
}

