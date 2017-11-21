package com.example.hello.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hello.R;
import com.example.hello.adapter.NoteAdapter;
import com.example.hello.constant.ConsLocal;
import com.example.hello.constant.Constant;
import com.example.hello.db.Note;
import com.example.hello.interf.OnItemClickListener;
import com.example.hello.interf.OnItemLongClickListener;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NoteActivity.this, NoteDetailActivity.class);
                i.putExtra("type", 0);
                startActivity(i);
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
                Intent i = new Intent(NoteActivity.this, NoteDetailActivity.class);
                i.putExtra("type", 1);
                i.putExtra("note", datas.get(position));
                startActivity(i);
            }
        });

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(NoteActivity.this)
                        .setTitle("删除该条?")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        Note user = realm.where(Note.class).equalTo("id", datas.get(position).getId()).findFirst();
                                        if (user != null)
                                            user.deleteFromRealm();
                                    }
                                });
                                getData(false);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();

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

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();
        getData(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_bin) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Realm realm;

    private void getData(boolean showDialog) {
        if (showDialog) {
            view.show(getSupportFragmentManager(), "");
        }
        RealmResults<Note> notes = realm.where(Note.class).findAllSorted("createTime", Sort.DESCENDING);
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

