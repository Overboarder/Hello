package com.example.hello.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hello.R;
import com.example.hello.adapter.NoteAdapter;
import com.example.hello.db.Note;
import com.example.hello.interf.OnItemClickListener;
import com.example.hello.interf.OnItemLongClickListener;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by john on 2017/11/16.
 */

public class NoteActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;

    private SwipeRefreshLayout srl;

    private NoteAdapter adapter;
    private List<Note> datas;

    private CatLoadingView view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        init();
        initView();
        getData(true);
    }

    private void init() {
        realm = Realm.getDefaultInstance();
        datas = new ArrayList<>();
        adapter = new NoteAdapter(datas, this);
    }

    private void initView() {
        view = new CatLoadingView();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("这叫什么呢");
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
        rlv.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 2017/11/20
//                Intent i = new Intent(NoteActivity.this, VpActivity.class);
//                i.putExtra("index", position);
//                i.putStringArrayListExtra("imageUrls", getUrls());
//                startActivity(i);
            }
        });

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 2017/11/20

            }
        });
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(false);
            }
        });

    }

    private Realm realm;

    private void getData(boolean showDialog) {
        if (showDialog) {
            view.show(getSupportFragmentManager(), "");
        }
        RealmResults<Note> notes = realm.where(Note.class).findAll();
        datas.clear();
        datas.addAll(realm.copyFromRealm(notes));
        adapter.notifyDataSetChanged();
        if (srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
        view.dismiss();

    }


    @Override
    public void onBackPressed() {
        if (srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
        view.dismiss();
        super.onBackPressed();
    }


}

