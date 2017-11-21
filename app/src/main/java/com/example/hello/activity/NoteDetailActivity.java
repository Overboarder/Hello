package com.example.hello.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.hello.R;
import com.example.hello.constant.ConsLocal;
import com.example.hello.constant.Constant;
import com.example.hello.db.Note;

import java.util.Random;
import java.util.UUID;

import io.realm.Realm;

/**
 * Created by john on 2017/11/16.
 */

public class NoteDetailActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;
    private EditText et_title, et_content;
    private LinearLayout ll_bg;
    private Realm realm;
    private Note note;

    private int type;//0.新建1.修改

    private int style;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notedetail);
        init();
        initView();
    }

    private void init() {
        realm = Realm.getDefaultInstance();
        style = new Random().nextInt(ConsLocal.noteBg.length);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        Log.e(TAG, "type==" + type);
        if (type == 1) {
            note = (Note) intent.getSerializableExtra("note");
            Log.e(TAG, "note == null" + ((note == null) ? true : false));
        }

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setTitle("新写");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                finish();
            }
        });
        ll_bg = findViewById(R.id.ll_bg);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);


        et_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s))
                    getSupportActionBar().setTitle(s);
                else {
                    getSupportActionBar().setTitle("新写");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if (type == 1) {
            getSupportActionBar().setTitle(note.getTitle());
            ll_bg.setBackgroundResource(ConsLocal.noteBg[note.getStyle()]);
            et_title.setText(note.getTitle());
            et_content.setText(note.getContent());
        } else {
            ll_bg.setBackgroundResource(ConsLocal.noteBg[style]);
        }

    }

    private void saveData() {
        final String title = et_title.getText().toString().trim();
        final String content = et_content.getText().toString().trim();
        if (type == 0) {
            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(content)) {
            } else {
                //插入一条新数据
                final Note n = new Note();
                long time = System.currentTimeMillis();
                n.setId(time);
                n.setTitle(title);
                n.setContent(content);
                n.setStyle(style);
                n.setType(0);
                n.setStatus(0);
                n.setCreateTime(time);
                n.setUpdateTime(time);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(n);
                    }
                });
            }
        } else if (type == 1) {
            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(content)) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Note n = realm.where(Note.class).equalTo("id", note.getId()).findFirst();
                        if (n != null)
                            n.deleteFromRealm();
                    }
                });
            } else {
                final Note n = new Note();
                n.setId(note.getId());
                n.setTitle(title);
                n.setContent(content);
                n.setStyle(note.getStyle());
                n.setType(note.getType());
                n.setStatus(note.getStatus());
                n.setCreateTime(note.getCreateTime());
                n.setUpdateTime(System.currentTimeMillis());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(n);
                    }
                });
            }
        }
    }


    @Override
    public void onBackPressed() {
        saveData();
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }

}

