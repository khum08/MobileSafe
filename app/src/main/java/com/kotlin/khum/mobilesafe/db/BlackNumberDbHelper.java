package com.kotlin.khum.mobilesafe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   : 黑名单数据库
 * </pre>
 */
public class BlackNumberDbHelper extends DbOpenHelper {

    public BlackNumberDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    protected String setDd() {
        return "create table black_number (_id integer primary key autoincrement,phone varchar(20),intercept integer)";
    }

}
