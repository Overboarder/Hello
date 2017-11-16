package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.activity.CatActivity;
import com.example.hello.bean.WeaBean;
import com.example.hello.constant.Constant;
import com.example.hello.util.JsonU;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Random;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public final String TAG = getClass().getSimpleName();

    private static final int[] notices = {R.string.notice_random1,
            R.string.notice_random2, R.string.notice_random3,
            R.string.notice_random4, R.string.notice_random5, R.string.notice_random6};
    private int position;


    private SwipeRefreshLayout srl_main;

    private TextView tv_text, tv_tem, tv_wind, tv_wet, tv_visibility, tv_pressure,
            tv_air_quality, tv_sunrise, tv_sunset, tv_dressing, tv_uv, tv_flu, tv_sport,
            tv_tomorrow, tv_totext, tv_towind, tv_totem, tv_future;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, notices[position % 6], Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                position++;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initView();

        getDatas();
    }


    private void initView() {
        srl_main = findViewById(R.id.srl_main);
        srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDatas();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_air_quality:

                break;
            case R.id.tv_dressing:

                break;
            case R.id.tv_uv:

                break;
            case R.id.tv_flu:

                break;
            case R.id.tv_sport:

                break;
            case R.id.tv_future:
//                Intent i = new Intent(this, WeaFuActivity.class);
//                startActivity(i);
                break;
            default:
                break;
        }
    }


    private void getDatas() {
        OkHttpUtils
                .get()
                .url(Constant.WEATHER + "?city=" + Constant.YANCHENG)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(MainActivity.this, "可能网络出错了", Toast.LENGTH_SHORT).show();
                        if (srl_main.isRefreshing()) {
                            srl_main.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "response==" + response);
                        WeaBean weaBean = JsonU.GsonToBean(response, WeaBean.class);
                        if (null != weaBean) {
                            // TODO: 2017/11/16
                            updateData(weaBean);
                        } else {
                            // TODO: 2017/11/16 catBean==null
                        }
                        if (srl_main.isRefreshing()) {
                            srl_main.setRefreshing(false);
                        }
                    }
                });
    }


    public void updateData(WeaBean weaBean) {
        WeaBean.WeatherBean w = weaBean.getWeather().get(0);
//        tv_cityname.setText(w.getCity_name());
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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.nav_bou) {
            intent = new Intent(this, CatActivity.class);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        //先关闭,再跳转
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        if (null != intent)
            startActivity(intent);
        return true;
    }


}
