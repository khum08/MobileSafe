package com.kotlin.khum.mobilesafe.ui.glideDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
public class GlideActivity extends AppCompatActivity{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] tab_title = {"Circle","Rounded","Blur","Gray","Round_Gray"};
    private com.kotlin.khum.mobilesafe.ui.glideDemo.VpAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        findView();
        initTab();
    }

    private void initTab() {
        mAdapter = new com.kotlin.khum.mobilesafe.ui.glideDemo.VpAdapter(getSupportFragmentManager(), tab_title);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void findView() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SparseArray<Fragment> fragmentMaps = FragmentFactory.fragmentMaps;
        Fragment fragment;
        for(int i = 0; i < fragmentMaps.size(); i++){
            fragment = fragmentMaps.get(i);
            fragment = null;
        }
        fragmentMaps.clear();
        fragmentMaps = null;
    }
}
