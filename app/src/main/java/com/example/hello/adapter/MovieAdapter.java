package com.example.hello.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hello.R;
import com.example.hello.bean.MovieBean;

import java.util.List;

/**
 * Created by john on 2017/11/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieBean.DataBean.MoviesBean> datas;
    private Context context;

    public MovieAdapter(List<MovieBean.DataBean.MoviesBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        // TODO: 2017/11/17
        Glide.with(context)
                .load(datas.get(position).getImg())
                .into(holder.iv_pic);
        holder.tv_info.setText(datas.get(position).getShowInfo());
        holder.tv_name.setText(datas.get(position).getNm());
        holder.tv_dir.setText(datas.get(position).getDir());
        holder.tv_star.setText(datas.get(position).getStar());
        holder.tv_cat.setText(datas.get(position).getCat());
        holder.tv_wish.setText(datas.get(position).getWish() + "想看");
        holder.tv_sc.setText(datas.get(position).getSc() + "分");
        holder.tv_ver.setText(datas.get(position).getVer());
        holder.tv_rt.setText(datas.get(position).getRt());
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_pic;
        TextView tv_info, tv_name, tv_dir, tv_star, tv_cat, tv_wish, tv_sc, tv_ver, tv_rt;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.iv_pic);
            tv_info = itemView.findViewById(R.id.tv_info);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dir = itemView.findViewById(R.id.tv_dir);
            tv_star = itemView.findViewById(R.id.tv_star);
            tv_cat = itemView.findViewById(R.id.tv_cat);
            tv_wish = itemView.findViewById(R.id.tv_wish);
            tv_sc = itemView.findViewById(R.id.tv_sc);
            tv_ver = itemView.findViewById(R.id.tv_ver);
            tv_rt = itemView.findViewById(R.id.tv_rt);
        }
    }


}
