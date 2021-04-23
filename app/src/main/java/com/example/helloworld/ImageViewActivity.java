package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4=findViewById(R.id.iv_4);
        Glide.with(this).load("https://s.cn.bing.net/th?id=OJ.56EFHyAvv6kqlw&w=693&h=280&c=8&pid=MSNJVFeeds").into(mIv4);
    }
}