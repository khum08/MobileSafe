package com.kotlin.khum.mobilesafe.ui.glideDemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class FragmentFactory {

    @Nullable
    public static Fragment getInstance(int position) {
        switch (position){
            case 0:
                return CircleFragment.getInstance();
            case 1:
                return RoundedFragment.getInstance();
            case 2:
                return BlurFragment.getInstance();
            case 3:
                return GrayFragment.getInstance();
            case 4:
                return RoundedAndGrayFragment.getInstance();
            default:
                return null;
        }
    }
}
