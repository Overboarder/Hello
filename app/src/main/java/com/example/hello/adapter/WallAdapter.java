package com.example.hello.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hello.R;
import com.example.hello.bean.CatBean;
import com.example.hello.bean.WallBean;
import com.example.hello.constant.Constant;
import com.example.hello.interf.OnItemClickListener;

import java.util.List;

/**
 * Created by john on 2017/11/16.
 */

public class WallAdapter extends RecyclerView.Adapter<WallAdapter.ViewHolder> implements View.OnClickListener {

    private List<WallBean.DataBean.HandBean> datas;
    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    public WallAdapter(List<WallBean.DataBean.HandBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public WallAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(WallAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(Constant.TOKEN + datas.get(position).getImageurl())
                .into(holder.cat_photo);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cat_photo;

        public ViewHolder(View itemView) {
            super(itemView);
            cat_photo = itemView.findViewById(R.id.cat_photo);
        }
    }

}
