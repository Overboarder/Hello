package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.adapter.CatAdapter;
import com.example.hello.bean.CatBean;
import com.example.hello.bean.WeaBean;
import com.example.hello.constant.Constant;
import com.example.hello.util.JsonU;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by john on 2017/11/16.
 */

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private SwipeRefreshLayout srl_main;

    private TextView tv_text, tv_tem, tv_wind, tv_wet, tv_visibility, tv_pressure,
            tv_air_quality, tv_sunrise, tv_sunset, tv_dressing, tv_uv, tv_flu, tv_sport,
            tv_tomorrow, tv_totext, tv_towind, tv_totem, tv_future;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        getData();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("盐城");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        srl_main = findViewById(R.id.srl_main);
        srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        tv_text = findViewById(R.id.tv_text);
        tv_tem = findViewById(R.id.tv_tem);
        tv_wind = findViewById(R.id.tv_wind);
        tv_wet = findViewById(R.id.tv_wet);
        tv_visibility = findViewById(R.id.tv_visibility);
        tv_pressure = findViewById(R.id.tv_pressure);
        tv_air_quality = findViewById(R.id.tv_air_quality);
        tv_sunrise = findViewById(R.id.tv_sunrise);
        tv_sunset = findViewById(R.id.tv_sunset);
        tv_dressing = findViewById(R.id.tv_dressing);
        tv_uv = findViewById(R.id.tv_uv);
        tv_flu = findViewById(R.id.tv_flu);
        tv_sport = findViewById(R.id.tv_sport);
        tv_tomorrow = findViewById(R.id.tv_tomorrow);
        tv_totext = findViewById(R.id.tv_totext);
        tv_towind = findViewById(R.id.tv_towind);
        tv_totem = findViewById(R.id.tv_totem);
        tv_future = findViewById(R.id.tv_future);

        tv_air_quality.setOnClickListener(this);

        tv_dressing.setOnClickListener(this);
        tv_uv.setOnClickListener(this);
        tv_flu.setOnClickListener(this);
        tv_sport.setOnClickListener(this);

        tv_future.setOnClickListener(this);

    }

    private void getData() {
        OkHttpUtils
                .get()
                .url(Constant.WEATHER + "?city=" + Constant.YANCHENG)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(WeatherActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
                        if (srl_main.isRefreshing()) {
                            srl_main.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e(TAG, "response==" + response);
                        WeaBean weaBean = JsonU.GsonToBean(response, WeaBean.class);
                        if (null != weaBean) {
                            weather = weaBean;
                            updateData(weaBean);
                        }
                        if (srl_main.isRefreshing()) {
                            srl_main.setRefreshing(false);
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_air_quality:

                break;
            case R.id.ll_dressing:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getDressing().getDetails())
                            .setCancelable(true)
                            .create()
                            .show();
                }
                break;
            case R.id.ll_uv:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getUv().getDetails())
                            .setCancelable(true)
                            .create()
                            .show();
                }
                break;
            case R.id.ll_flu:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getFlu().getDetails())
                            .setCancelable(true)
                            .create()
                            .show();
                }
                break;
            case R.id.ll_sport:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getSport().getDetails())
                            .setCancelable(true)
                            .create()
                            .show();
                }
                break;
            case R.id.tv_future:
//                Intent i = new Intent(this, WeaFuActivity.class);
//                startActivity(i);
                break;
            default:
                break;
        }
    }


    private WeaBean weather;

    public void updateData(WeaBean weaBean) {
        WeaBean.WeatherBean w = weaBean.getWeather().get(0);
        tv_text.setText(w.getNow().getText());
        tv_tem.setText(w.getNow().getTemperature() + "°");
        tv_wind.setText(w.getNow().getWind_direction() + "风" + w.getNow().getWind_scale() + "级");
        tv_wet.setText(w.getNow().getHumidity() + "%");
        tv_visibility.setText(w.getNow().getVisibility() + "km");
        tv_pressure.setText(w.getNow().getPressure() + "hPa");
        tv_air_quality.setText(w.getNow().getAir_quality().getCity().getAqi() + "  " + w.getNow().getAir_quality().getCity().getQuality());

        tv_sunrise.setText(w.getToday().getSunrise());
        tv_sunset.setText(w.getToday().getSunset());
        tv_dressing.setText(w.getToday().getSuggestion().getDressing().getBrief());
        tv_uv.setText(w.getToday().getSuggestion().getUv().getBrief());
        tv_flu.setText(w.getToday().getSuggestion().getFlu().getBrief());
        tv_sport.setText(w.getToday().getSuggestion().getSport().getBrief());

        tv_tomorrow.setText("明天" + w.getFuture().get(1).getDay());
        tv_totext.setText(w.getFuture().get(1).getText());
        tv_towind.setText(w.getFuture().get(1).getWind());
        tv_totem.setText(w.getFuture().get(1).getLow() + "°~" + w.getFuture().get(1).getHigh() + "°");


    }


}

