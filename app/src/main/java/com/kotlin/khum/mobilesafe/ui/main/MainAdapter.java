package com.kotlin.khum.mobilesafe.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kotlin.khum.mobilesafe.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/24
 *     desc   :
 * </pre>
 */
//原生的adapter书写
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolder>{

    String[] mModuleTitles = {"1","防火墙","搜索","弹出框","流量统计","手机杀毒",
            "主页","系统主页","设置","AIDL","ImageLoader","自定义View","Glide","14"};

    int[] mDrawables = { R.mipmap.home_1, R.mipmap.home_2,
            R.mipmap.home_3, R.mipmap.home_4,
            R.mipmap.home_5, R.mipmap.home_6,
            R.mipmap.home_7, R.mipmap.home_8,
            R.mipmap.home_9, R.mipmap.home_10,
            R.mipmap.home_11,R.mipmap.home_12,
            R.mipmap.home_13,R.mipmap.home_14};
    private Context mContext;
    public MainAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyHolder holder, int position) {
        Drawable drawable = mContext.getResources().getDrawable(mDrawables[position]);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        holder.mTextView.setCompoundDrawables(null,drawable,null,null);
        holder.mTextView.setText(mModuleTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mModuleTitles.length;
    }

    //静态viewHolder类
    static class MyHolder extends RecyclerView.ViewHolder{
        private final TextView mTextView;
        public MyHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_grid);
        }
    }
}





