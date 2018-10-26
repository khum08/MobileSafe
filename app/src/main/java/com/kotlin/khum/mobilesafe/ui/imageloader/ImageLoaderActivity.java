package com.kotlin.khum.mobilesafe.ui.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/27
 *     desc   :
 * </pre>
 */
public class ImageLoaderActivity extends BaseActivity {

    private ImageView mIv_1;
    private ImageView mIv_2;
    private String url_1 = "https://kun-image.oss-cn-hangzhou.aliyuncs.com/piao1.jpg";
    private String url_2 = "https://kun-image.oss-cn-hangzhou.aliyuncs.com/piao1.jpg";


    @Override
    protected void initView() {
        mIv_1 = findViewById(R.id.iv_1);
        mIv_2 = findViewById(R.id.iv_2);
        renderView();
    }

    private void renderView(){
        Glide.with(this).load(url_1).centerCrop().error(R.mipmap.ic_launcher)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(mIv_1);

        Glide.with(this).load(url_2).error(R.mipmap.ic_launcher)
                .bitmapTransform(new RoundedCornersTransformation(this,20,0))
                .into(mIv_2);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_image_loader;
    }
}
