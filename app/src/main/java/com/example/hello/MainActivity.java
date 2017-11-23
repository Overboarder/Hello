package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hello.activity.ArticleActivity;
import com.example.hello.activity.CatActivity;
import com.example.hello.activity.KissActivity;
import com.example.hello.activity.MovieActivity;
import com.example.hello.activity.NoteActivity;
import com.example.hello.activity.SettingActivity;
import com.example.hello.activity.WallpaperActivity;
import com.example.hello.activity.WeatherActivity;
import com.example.hello.bean.DayBean;
import com.example.hello.constant.ConsLocal;
import com.example.hello.constant.Constant;
import com.example.hello.update.UpdateAppHttpUtil;
import com.example.hello.util.DateU;
import com.example.hello.util.JsonU;
import com.example.hello.util.L;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.vector.update_app.utils.AppUpdateUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Random;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final String TAG = getClass().getSimpleName();

    private int position;

    private ImageView  iv_bg;


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
                Snackbar.make(view, ConsLocal.notices[position % 6], Snackbar.LENGTH_LONG)
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

        iv_bg = findViewById(R.id.iv_bg);

//        getHoliday();


        //自动检查是否有新版本
        updateApp();
    }

    public void updateApp() {
        final int versionCode = AppUpdateUtils.getVersionCode(this);
        new UpdateAppManager
                .Builder()
                //当前Activity
                .setActivity(this)
                //更新地址
                .setUpdateUrl(Constant.UPDATE)
                //实现httpManager接口的对象
                .setHttpManager(new UpdateAppHttpUtil())
                .build()
                .checkNewApp(new UpdateCallback() {
                    /**
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        try {
                            L.e(TAG, "json==" + json);
                            JSONObject jsonObject = new JSONObject(json);
                            updateAppBean
                                    //（必须）是否更新Yes,No
                                    .setUpdate(jsonObject.optInt("versioncode") > versionCode ? "Yes" : "No")
                                    //（必须）新版本号，
                                    .setNewVersion(jsonObject.optString("new_version"))
                                    //（必须）下载地址
                                    .setApkFileUrl(jsonObject.optString("apk_file_url"))
                                    //（必须）更新内容
                                    .setUpdateLog(jsonObject.optString("update_log"))
                                    //大小，不设置不显示大小，可以不设置
                                    .setTargetSize(jsonObject.optString("target_size"))
                                    //是否强制更新，可以不设置
                                    .setConstraint(false)
                                    //设置md5，可以不设置
                                    .setNewMd5(jsonObject.optString("new_md51"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return updateAppBean;
                    }

                    @Override
                    protected void hasNewApp(UpdateAppBean updateApp, UpdateAppManager updateAppManager) {
                        updateAppManager.showDialogFragment();
                    }

                    /**
                     * 网络请求之前
                     */
                    @Override
                    public void onBefore() {
//                        CProgressDialogUtils.showProgressDialog(MainActivity.this);
                    }

                    /**
                     * 网路请求之后
                     */
                    @Override
                    public void onAfter() {
//                        CProgressDialogUtils.cancelProgressDialog(MainActivity.this);
                    }

                    /**
                     * 没有新版本
                     */
                    @Override
                    public void noNewApp() {

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkTime();
//        switch (DateU.dayType()) {
//            case 0:
//                checkTime();
//                break;
//            case 1:
//                setSnow();
//                getSupportActionBar().setTitle("小雪");
//                break;
//            case 2:
//                setThanks();
//                getSupportActionBar().setTitle("感恩节");
//                break;
//            default:
//                checkTime();
//                break;
//        }
    }

//    private void setSnow() {
//        Glide.with(this)
//                .load(ConsLocal.snow[new Random().nextInt(ConsLocal.snow.length)])
//                .into(iv_bg);
//    }
//
//    private void setThanks() {
//        Glide.with(this)
//                .load(R.mipmap.thanks)
//                .into(iv_bg);
//    }


    private void checkTime() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 7) {
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.bg_midnight)
                    .into(iv_bg);
        } else if (hour >= 7 && hour < 18) {
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.bg_day)
                    .into(iv_bg);
        } else if (hour >= 18 && hour < 24) {
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.bg_night)
                    .into(iv_bg);
        }
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
        } else if (id == R.id.nav_article) {
            intent = new Intent(this, ArticleActivity.class);
        } else if (id == R.id.nav_weather) {
            intent = new Intent(this, WeatherActivity.class);
        } else if (id == R.id.nav_hand) {
            intent = new Intent(this, WallpaperActivity.class);
        } else if (id == R.id.nav_movie) {
            intent = new Intent(this, MovieActivity.class);
        } else if (id == R.id.nav_note) {
            intent = new Intent(this, NoteActivity.class);
        } else if (id == R.id.nav_send) {
            intent = new Intent(this, KissActivity.class);
        } else if (id == R.id.nav_about) {
            intent = new Intent(this, SettingActivity.class);
        }
        //先关闭,再跳转
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        if (null != intent)
            startActivity(intent);
        return true;
    }


    private void getHoliday() {
        OkHttpUtils
                .get()
                .url(Constant.HOLIDAY)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        DayBean bean = JsonU.GsonToBean(response, DayBean.class);
                        if (null != bean) {
//                            if (null == bean.getData().getFestivalList()) {
//                                L.e(TAG, "null == bean.getData().getFestivalList()");
//                            } else if (bean.getData().getFestivalList().size() > 0) {
//                                L.e(TAG, "bean.getData().getFestivalList().size() > 0");
//                                getSupportActionBar().setTitle(bean.getData().getFestivalList().get(0));
//                            }
                        }
                    }
                });
    }


}
