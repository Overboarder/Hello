package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hello.R;
import com.example.hello.bean.ArticleBean;
import com.example.hello.constant.Constant;
import com.example.hello.util.JsonU;
import com.google.gson.Gson;
import com.roger.catloadinglibrary.CatLoadingView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import okhttp3.Call;

/**
 * Created by john on 2017/11/16.
 */

public class ArticleActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private SwipeRefreshLayout srl;
    private TextView tv_title, tv_author_wc, tv_content;

    private CatLoadingView load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        mQueue = Volley.newRequestQueue(this);
        initView();
        getData();
    }


    private void initView() {
        load = new CatLoadingView();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("一篇小文");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        srl = findViewById(R.id.srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData1();
            }
        });

        tv_title = findViewById(R.id.tv_title);
        tv_author_wc = findViewById(R.id.tv_author_wc);
        tv_content = findViewById(R.id.tv_content);
    }


    private RequestQueue mQueue;

    private void getData() {
        load.show(getSupportFragmentManager(), "");
        mQueue.add(today);
    }

    private void getData1() {
        mQueue.add(random);
    }

    StringRequest today = new StringRequest(Constant.TODAYARTICLE,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    ArticleBean articleBean = new Gson().fromJson(response, ArticleBean.class);
                    if (null != articleBean) {
                        Log.e(TAG, "haole");
                        update(articleBean);
                    } else {
                        Log.e(TAG, "kongle");
                    }
                    if (srl.isRefreshing()) {
                        srl.setRefreshing(false);
                    }
                    load.dismiss();
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onErrorResponse TAG", error.getMessage(), error);
            if (srl.isRefreshing()) {
                srl.setRefreshing(false);
            }
            load.dismiss();
            Toast.makeText(ArticleActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
        }
    });

    StringRequest random = new StringRequest(Constant.RANDOMARTICLE,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    ArticleBean articleBean = new Gson().fromJson(response, ArticleBean.class);
                    if (null != articleBean) {
                        Log.e(TAG, "haole");
                        update(articleBean);
                    } else {
                        Log.e(TAG, "kongle");
                    }
                    if (srl.isRefreshing()) {
                        srl.setRefreshing(false);
                    }
                    load.dismiss();
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onErrorResponse TAG", error.getMessage(), error);
            if (srl.isRefreshing()) {
                srl.setRefreshing(false);
            }
            load.dismiss();
            Toast.makeText(ArticleActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
        }
    });


    private void update(ArticleBean articleBean) {
        toolbar.setTitle(articleBean.getData().getTitle());
        tv_title.setText(articleBean.getData().getTitle());
        tv_author_wc.setText(articleBean.getData().getAuthor() + "  " + articleBean.getData().getWc() + "字");
        Log.e(TAG, "--------" + articleBean.getData().getContent());
        tv_content.setText(Html.fromHtml(articleBean.getData().getContent()));
        Log.e(TAG, "--------" + Html.fromHtml(articleBean.getData().getContent()));
    }

}

