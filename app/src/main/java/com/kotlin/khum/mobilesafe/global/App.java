package com.kotlin.khum.mobilesafe.global;

import android.app.Application;

/**
 * <pre>
 *     author : yuanzhenkun
 *     time   : 2018/8/26
 *     desc   :
 * </pre>
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String str = "Hello";
        str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char temp;
        for (int i=0;i<str.length();i++){
            temp = str.charAt(i);
            if(temp<97){
                sb.append((char)(str.charAt(i)+32));
            }else{
                sb.append(temp);
            }
        }
    }
}
