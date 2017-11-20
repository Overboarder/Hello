package com.example.hello.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hello.R;
import com.example.hello.constant.Constant;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;

/**
 * Created by john on 2017/11/16.
 */

public class VpActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    public int index;
    public ArrayList<String> datas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpimage);
        init();
        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(new SamplePagerAdapter(datas));
        viewPager.setCurrentItem(index);

    }


    private void init() {
        datas = new ArrayList<>();
        Intent i = getIntent();
        index = i.getIntExtra("index", 0);
        Log.e(TAG, "index==" + index);
        datas.addAll(i.getStringArrayListExtra("imageUrls"));
        Log.e(TAG, "datas.size()==" + datas.size());

    }


    class SamplePagerAdapter extends PagerAdapter {

        private ArrayList<String> imageUrls;

        public SamplePagerAdapter(ArrayList<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        @Override
        public int getCount() {
            return imageUrls.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
//            photoView.setImageResource(sDrawables[position]);

            Glide.with(container.getContext())
                    .load(imageUrls.get(position))
                    .into(photoView);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float v, float v1) {
                    finish();
                }

                @Override
                public void onOutsidePhotoTap() {
                    finish();
                }
            });

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}


