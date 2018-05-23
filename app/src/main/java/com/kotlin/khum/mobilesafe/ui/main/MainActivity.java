package com.kotlin.khum.mobilesafe.ui.main;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;
import com.kotlin.khum.mobilesafe.global.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private RecyclerView recycler_view;
    private TextView tv_ad;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        findView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recycler_view.setLayoutManager(layoutManager);
        String[] moduleTitle = {"手机防盗","通讯卫士","软件管理","进程管理","流量统计","手机杀毒",
                                    "缓存清理","高级工具","设置中心"};
        List<Drawable> list = getDrawable();
        MyAdapter adapter = new MyAdapter(moduleTitle, list);
        recycler_view.setAdapter(adapter);
    }

    private List<Drawable> getDrawable() {
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable4 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable5 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable6 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable7 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable8 = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable9 = getResources().getDrawable(R.drawable.ic_launcher_background);
        List<Drawable> list = new ArrayList<>();
        list.add(drawable1);
        list.add(drawable2);
        list.add(drawable3);
        list.add(drawable4);
        list.add(drawable5);
        list.add(drawable6);
        list.add(drawable7);
        list.add(drawable8);
        list.add(drawable9);
        return list;
    }

    private void findView() {
        recycler_view = findViewById(R.id.recycler_view);
        tv_ad= findViewById(R.id.tv_ad);
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolder>{

        private String[] mModuleTitles;
        private List<Drawable> mDrawables;
        public MyAdapter(String[] moduleTitle, List<Drawable> drawables) {
            this.mModuleTitles = moduleTitle;
            this.mDrawables = drawables;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_grid, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.mTextView.setCompoundDrawables(null,mDrawables.get(position),null,null);
            holder.mTextView.setText(mModuleTitles[position]);
        }

        @Override
        public int getItemCount() {
            return mModuleTitles.length;
        }
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        private final TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_grid);
        }

    }


}
