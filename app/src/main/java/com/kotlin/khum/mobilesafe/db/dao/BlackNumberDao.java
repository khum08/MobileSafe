package com.kotlin.khum.mobilesafe.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kotlin.khum.mobilesafe.db.BlackNumberDbHelper;
import com.kotlin.khum.mobilesafe.db.domain.BlackNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   :
 * </pre>
 */
public class BlackNumberDao {

    private final BlackNumberDbHelper mDbHelper;
    private static BlackNumberDao sBlackNumberDao;
    private static String table_name = "black_number";

    private BlackNumberDao(Context context) {
        mDbHelper = new BlackNumberDbHelper(context, "blackNumber.db", null, 1);
    }

    public static BlackNumberDao getInstance(Context context) {
        if (sBlackNumberDao == null) {
            sBlackNumberDao = new BlackNumberDao(context);
        }
        return sBlackNumberDao;
    }

    /**
     * 插入一条黑名单号码
     * @param phone
     * @param intercept
     * @return
     */
    public boolean insert(String phone,int intercept){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        values.put("intercept", intercept);
        long black_number = db.insert(table_name, null, values);
        db.close();
        return black_number==-1?false:true;
    }

    /**
     * 删除一条黑名单号码
     * @param phone
     * @return
     */
    public boolean delete(String phone){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        int delete = db.delete(table_name, "phone=?", new String[]{phone});
        db.close();
        return delete==0?false:true;
    }

    /**
     *  查询数据库
     * @param startIndex
     * @param selectCount
     * @return
     */
    public List<BlackNumber> query(int startIndex,int selectCount){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select phone,intercept from black_number order by _id desc limit ?,?",
                new String[]{String.valueOf(startIndex), String.valueOf(selectCount)});
        List<BlackNumber> list = new ArrayList<>();
        BlackNumber blackNumber;
        while (cursor.moveToNext()){
            blackNumber = new BlackNumber(cursor.getString(0), cursor.getInt(1));
            list.add(blackNumber);
        }
        cursor.close();
        db.close();
        return list;
    }


}
