package com.example.hello.activity;

import android.content.Intent;
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
import com.example.hello.bean.CatBean;
import com.example.hello.constant.ConsLocal;
import com.example.hello.constant.Constant;
import com.example.hello.interf.OnItemClickListener;
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

public class CatActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private SwipeRefreshLayout srl;

    private CatAdapter catAdapter;
    private List<CatBean.DataBean.RagdollBean> cats;


    private CatLoadingView view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        init();
        initView();
        getData(true);
    }

    private void init() {
        cats = new ArrayList<>();
        catAdapter = new CatAdapter(cats, this);
    }

    private void initView() {
        view = new CatLoadingView();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("布偶猫");
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
        catAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(CatActivity.this, VpActivity.class);
                i.putExtra("index", position);
                i.putStringArrayListExtra("imageUrls", getUrls());
                startActivity(i);
            }
        });
        srl.setColorSchemeResources(ConsLocal.colors);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(false);
            }
        });

    }

    private void getData(boolean showDialog) {
        if (showDialog) {
            view.show(getSupportFragmentManager(), "");
        }
        OkHttpUtils
                .get()
                .url(Constant.CAT)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (srl.isRefreshing()) {
                            srl.setRefreshing(false);
                        }
                        view.dismiss();
                        Toast.makeText(CatActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e(TAG, "response==" + response);
                        CatBean catBean = JsonU.GsonToBean(response, CatBean.class);
                        if (null != catBean) {
                            if (null != catBean.getData().getRagdoll() && catBean.getData().getRagdoll().size() > 0) {
                                cats.clear();
                                cats.addAll(catBean.getData().getRagdoll());
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


    private ArrayList<String> getUrls() {
        ArrayList<String> str = new ArrayList<>();
        for (CatBean.DataBean.RagdollBean ra : cats) {
            str.add(Constant.TOKEN + ra.getImageurl());
        }
        return str;
    }

}

