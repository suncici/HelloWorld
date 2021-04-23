package com.example.helloworld.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.helloworld.R;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        mTvTest=findViewById(R.id.tv);
       // mTvTest.animate().rotationYBy(500).setDuration(2000).start();

       // mTvTest.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //valueAnimator 实际的值
//                Log.d("aaaa",animation.getAnimatedValue()+"");
//                //valueAnimator 动画进度0-1
//                Log.d("aaaa",animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mTvTest,"translationY",0,500,200,800);
        objectAnimator.setDuration(2000).start();
    }
}