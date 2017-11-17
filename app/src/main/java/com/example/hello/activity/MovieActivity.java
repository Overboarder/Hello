package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.adapter.MovieAdapter;
import com.example.hello.adapter.WallAdapter;
import com.example.hello.bean.MovieBean;
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

public class MovieActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();


    private SwipeRefreshLayout srl;

    private MovieAdapter movieAdapter;
    private List<MovieBean.DataBean.MoviesBean> datas;

    private CatLoadingView load;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        init();
        initView();
        getData(true);
    }

    private void init() {
        datas = new ArrayList<>();
        movieAdapter = new MovieAdapter(datas, this);
    }

    private void initView() {
        load = new CatLoadingView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("最近");
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
        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setAdapter(movieAdapter);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(false);
            }
        });

    }

    private void getData(boolean showDialog) {
        if (showDialog) {
            load.show(getSupportFragmentManager(), "");
        }
        OkHttpUtils
                .get()
                .url(Constant.MOVIE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (srl.isRefreshing()) {
                            srl.setRefreshing(false);
                        }
                        load.dismiss();
                        Toast.makeText(MovieActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e(TAG, "response==" + response);
                        MovieBean bean = JsonU.GsonToBean(response, MovieBean.class);
                        if (null != bean) {
                            if (null != bean.getData().getMovies() && bean.getData().getMovies().size() > 0) {
                                datas.clear();
                                datas.addAll(bean.getData().getMovies());
                                movieAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.e(TAG, "null == bean");
                        }
                        if (srl.isRefreshing()) {
                            srl.setRefreshing(false);
                        }
                        load.dismiss();
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

