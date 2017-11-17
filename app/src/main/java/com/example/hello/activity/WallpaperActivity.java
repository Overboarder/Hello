package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.adapter.CatAdapter;
import com.example.hello.adapter.WallAdapter;
import com.example.hello.bean.CatBean;
import com.example.hello.bean.WallBean;
import com.example.hello.constant.Constant;
import com.example.hello.util.JsonU;
import com.roger.catloadinglibrary.CatLoadingView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by john on 2017/11/16.
 */

public class WallpaperActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private SwipeRefreshLayout srl;

    private WallAdapter catAdapter;
    private List<WallBean.DataBean.HandBean> cats;

    private CatLoadingView view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        init();
        initView();
        getData(true);
    }

    private void init() {
        cats = new ArrayList<>();
        catAdapter = new WallAdapter(cats, this);
    }

    private void initView() {
        view = new CatLoadingView();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("手绘");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        srl = findViewById(R.id.srl);
        RecyclerView rlv = findViewById(R.id.rlv);

        rlv.setHasFixedSize(true);
        rlv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rlv.setAdapter(catAdapter);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(false);
            }
        });
    }

    private void getData(boolean show) {
        if (show) {
            view.show(getSupportFragmentManager(), "");
        }
        OkHttpUtils
                .get()
                .url(Constant.WALLPAPER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (srl.isRefreshing()) {
                            srl.setRefreshing(false);
                        }
                        view.dismiss();
                        Toast.makeText(WallpaperActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e(TAG, "response==" + response);
                        WallBean catBean = JsonU.GsonToBean(response, WallBean.class);
                        if (null != catBean) {
                            if (null != catBean.getData().getHand() && catBean.getData().getHand().size() > 0) {
                                cats.clear();
                                cats.addAll(catBean.getData().getHand());
                                catAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.e(TAG, "null == catBean");
                        }
                        if (srl.isRefreshing()) {
                            srl.setRefreshing(false);
                        }
                        view.dismiss();
                    }

                });
    }


    @Override
    public void onBackPressed() {
        if (srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
        super.onBackPressed();
    }


}

