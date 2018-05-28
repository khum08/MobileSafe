package com.kotlin.khum.mobilesafe.db;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/28
 *     desc   : 数据库处理工具类
 * </pre>
 */
public class DbUtils {

    //init database
    private void copyDb(Context context,String database){
        File desFile = new File(context.getFilesDir(),database);
        if(desFile.exists()){
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream(desFile);
            in = context.getAssets().open(database);
            byte[] buffer = new byte[1024];
            int len;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context,"文件没有找到",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,"文件读取失败",Toast.LENGTH_LONG).show();
        }finally{
            try {
                assert in != null;
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context,"IO未正常关闭",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
