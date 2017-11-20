package com.example.hello.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.hello.R;
import com.example.hello.db.Note;

import io.realm.Realm;

/**
 * Created by john on 2017/11/16.
 */

public class NoteDetailActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private Toolbar toolbar;
    private EditText et_title, et_content;
    private Realm realm;
    private Note note;

    private int type;//0.新建1.修改


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notedetail);
        init();
        initView();
    }

    private void init() {
        realm = Realm.getDefaultInstance();
        note = new Note();
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        if (type == 1) {
            Note n = (Note) intent.getSerializableExtra("note");
            note.setId(n.getId());
            note.setCreateTime(n.getCreateTime());
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
                finish();
            }
        });

        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);

    }

    private void saveData() {
        String title = et_title.getText().toString().trim();
        String content = et_content.getText().toString().trim();
        if (TextUtils.isEmpty(title) && TextUtils.isEmpty(content)) {
            return;
        }
        note.setTitle(title);
        note.setContent(content);
        note.setType(0);
        note.setStatus(0);
        long time = System.currentTimeMillis();
        note.setCreateTime(time);
        note.setUpdateTime(time);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(note);
            }
        });

    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

