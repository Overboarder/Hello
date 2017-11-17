package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.bean.WeaBean;
import com.example.hello.constant.ConsLocal;
import com.example.hello.constant.Constant;
import com.example.hello.util.CalU;
import com.example.hello.util.JsonU;
import com.roger.catloadinglibrary.CatLoadingView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import okhttp3.Call;

/**
 * Created by john on 2017/11/16.
 */

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private ScrollView scroll;
    private SwipeRefreshLayout srl_main;

    private TextView tv_text, tv_tem, tv_wind, tv_wet, tv_visibility, tv_pressure,
            tv_air_quality, tv_sunrise, tv_sunset, tv_dressing, tv_uv, tv_flu, tv_sport,
            tv_tomorrow, tv_totext, tv_towind, tv_totem, tv_future;
    private ImageView iv_pic;

    private String currentCity;

    private CatLoadingView load;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        init();
    }

    private void initView() {
        load = new CatLoadingView();
        scroll = findViewById(R.id.scroll);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("天气");
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
                getData(false);
            }
        });
        tv_text = findViewById(R.id.tv_text);
        iv_pic = findViewById(R.id.iv_pic);
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

        tv_future.setOnClickListener(this);
    }

    private void init() {
        //初始默认盐城
        currentCity = Constant.YANCHENG;
        getSupportActionBar().setTitle(R.string.city_yancheng);
        getData(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_yancheng) {
            currentCity = Constant.YANCHENG;
            getSupportActionBar().setTitle(R.string.city_yancheng);
            getData(true);
            return true;
        }
        if (id == R.id.action_wuxi) {
            currentCity = Constant.WUXI;
            getSupportActionBar().setTitle(R.string.city_wuxi);
            getData(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData(boolean showDialog) {
        if (showDialog) {
            load.show(getSupportFragmentManager(), "");
        }
        OkHttpUtils
                .get()
                .url(Constant.WEATHER + "?city=" + currentCity)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (srl_main.isRefreshing()) {
                            srl_main.setRefreshing(false);
                        }
                        load.dismiss();
                        Toast.makeText(WeatherActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
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
                        load.dismiss();
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
                            .create()
                            .show();
                }
                break;
            case R.id.ll_uv:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getUv().getDetails())
                            .create()
                            .show();
                }
                break;
            case R.id.ll_flu:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getFlu().getDetails())
                            .create()
                            .show();
                }
                break;
            case R.id.ll_sport:
                if (null != weather) {
                    new AlertDialog.Builder(this)
                            .setMessage(weather.getWeather().get(0).getToday().getSuggestion().getSport().getDetails())
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
        int weatype = CalU.calWea(Integer.valueOf(w.getNow().getCode()));
        //api 21
        scroll.setBackground(getDrawable(ConsLocal.weaBg[weatype]));
        iv_pic.setImageResource(ConsLocal.weaIcon[weatype]);
        tv_text.setText(w.getNow().getText());
        tv_tem.setText(w.getNow().getTemperature() + "°");
        tv_wind.setText(w.getNow().getWind_direction() + "风" + w.getNow().getWind_scale() + "级");
        tv_wet.setText(w.getNow().getHumidity());
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

