package com.kotlin.khum.mobilesafe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   : SQLiteOpenHelper这个类存在的意义是让框架掌握SQLite的操作,实现框架的IoC（控制反转）思想，
 *              利用模板方法的设计模式，让框架的基类调用的我们写的子类，让程序的运行流程掌握在框架手上。
 *              这是常用的架构设计思想
 * </pre>
 */
public abstract class DbOpenHelper extends SQLiteOpenHelper {

    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(setDd());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    //设置创建表的sql语句
    protected abstract String setDd();
}
