package com.kotlin.khum.mobilesafe.ui.GlideDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kotlin.khum.mobilesafe.R;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class GrayFragment extends Fragment {

    private View mRootView;
    private ImageView mImageView;
    private static Fragment sInstance = new GrayFragment();

    public static Fragment getInstance() {
        return sInstance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.view_iv, container, false);
        mImageView = mRootView.findViewById(R.id.image_view);
        Glide.with(this)
                .load(UrlStatic.url1)
                .bitmapTransform(new GrayscaleTransformation(getContext()))
                .into(mImageView);
        return mRootView;
    }
}
