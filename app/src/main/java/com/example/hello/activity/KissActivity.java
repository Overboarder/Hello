package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.hello.R;
import com.example.hello.bean.ArticleBean;
import com.example.hello.constant.Constant;
import com.google.gson.Gson;
import com.roger.catloadinglibrary.CatLoadingView;

/**
 * Created by john on 2017/11/16.
 */

public class KissActivity extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();

    private ImageView iv_kiss;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiss);

        iv_kiss = findViewById(R.id.iv_kiss);
        iv_kiss.setOnClickListener(this);

        Glide.with(this)
                .asGif()
                .load(R.drawable.xiaohuangren)
                .into(iv_kiss);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}

