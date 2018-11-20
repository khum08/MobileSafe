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

import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class RoundedAndGrayFragment extends BaseFragment {

    private View mRootView;
    private ImageView mImage_view;
    public static BaseFragment instance;

    public static Fragment getInstance(){
        if (instance == null){
            new RoundedAndGrayFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.view_iv, container, false);
        mImage_view = mRootView.findViewById(R.id.image_view);
        Glide.with(this)
                .load(UrlStatic.url1)
                .bitmapTransform(new RoundedCornersTransformation(getContext(), 30,0),
                        new GrayscaleTransformation(getContext()))
                .into(mImage_view);

        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
