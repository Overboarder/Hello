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
import com.example.hello.constant.Constant;

import java.util.List;

/**
 * Created by john on 2017/11/16.
 */

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private List<CatBean.DataBean.RagdollBean> datas;
    private Context context;

    public CatAdapter(List<CatBean.DataBean.RagdollBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CatAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(Constant.TOKEN + datas.get(position).getImageurl())
                .into(holder.cat_photo);
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cat_photo;

        public ViewHolder(View itemView) {
            super(itemView);
            cat_photo = itemView.findViewById(R.id.cat_photo);
        }
    }

}
