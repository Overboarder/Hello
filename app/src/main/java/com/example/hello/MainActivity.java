package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hello.activity.ArticleActivity;
import com.example.hello.activity.CatActivity;
import com.example.hello.activity.KissActivity;
import com.example.hello.activity.MovieActivity;
import com.example.hello.activity.NoteActivity;
import com.example.hello.activity.WallpaperActivity;
import com.example.hello.activity.WeatherActivity;
import com.example.hello.bean.WeaBean;
import com.example.hello.constant.Constant;
import com.example.hello.util.JsonU;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Random;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final String TAG = getClass().getSimpleName();

    private static final int[] notices = {R.string.notice_random1,
            R.string.notice_random2, R.string.notice_random3,
            R.string.notice_random4, R.string.notice_random5, R.string.notice_random6};
    private int position;

    private ImageView iv_bg;


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

        iv_bg = findViewById(R.id.iv_bg);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setBg();
    }

    private void setBg() {
        String bg = Constant.BG + new Random().nextInt(Constant.BG_AMOUNT) + Constant.BG_TYPE;
        Glide.with(this)
                .load(bg)
                .into(iv_bg);
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
        }
        //先关闭,再跳转
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        if (null != intent)
            startActivity(intent);
        return true;
    }


}
