package com.kotlin.khum.mobilesafe.ui.glideDemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class FragmentFactory {
    public static SparseArray<Fragment> fragmentMaps = new SparseArray();
    @Nullable
    public static Fragment getInstance(int position) {
        Fragment fragment = fragmentMaps.get(position);
        if (fragment == null){
            switch (position){
                case 0:
                    fragment =  CircleFragment.getInstance();
                case 1:
                    fragment = RoundedFragment.getInstance();
                case 2:
                    fragment = BlurFragment.getInstance();
                case 3:
                    fragment = GrayFragment.getInstance();
                case 4:
                    fragment = RoundedAndGrayFragment.getInstance();
            }
            fragmentMaps.put(position, fragment);
        }
        return fragment;
    }
}
