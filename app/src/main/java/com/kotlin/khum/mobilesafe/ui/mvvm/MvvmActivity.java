package com.kotlin.khum.mobilesafe.ui.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/8
 *     desc   :
 * </pre>
 */
public class MvvmActivity extends AppCompatActivity {

    public static void starter(Context context){
        context.startActivity(new Intent(context, MvvmActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = new User("王二小", "二蛋", 30);
        user.setAge(18);
        user.setHobby(null);
    }
}
