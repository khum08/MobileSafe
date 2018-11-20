package com.kotlin.khum.mobilesafe.ui.glideDemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kotlin.khum.mobilesafe.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class BlurFragment extends BaseFragment{

    private ImageView mImageView;
    private View rootView;
    public static BaseFragment instance;

    public static Fragment getInstance(){
        if (instance==null){
            instance = new BlurFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_iv, container,false);
        mImageView = rootView.findViewById(R.id.image_view);
        Glide.with(getContext()).load(UrlStatic.url1)
                .bitmapTransform(new BlurTransformation(getContext()))
                .into(mImageView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
