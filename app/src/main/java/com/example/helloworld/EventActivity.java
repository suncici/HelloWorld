package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEvent,mBtnHandler;
    private MyButton mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent=findViewById(R.id.btn_event);
        mBtnMy=findViewById(R.id.btn_my);
        mBtnHandler=findViewById(R.id.btn_handler);

        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","--------onTouch----------");
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener","--------onClick----------");
            }
        });
        //内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
//        //匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("匿名内部类","click");
//                ToastUtil.showMsg(EventActivity.this,"click....");
//            }
//        });
//         //通过事件源所在类实现
//         mBtnEvent.setOnClickListener(EventActivity.this);
//        //通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_event:
                Log.d("布局文件","click");
                ToastUtil.showMsg(EventActivity.this,"click....");
                break;

        }
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    Log.d("内部类","click");
                    ToastUtil.showMsg(EventActivity.this,"click....");
                    break;

            }
        }
    }

//    public void show(View v) {
//        switch (v.getId()){
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this,"click....");
//                break;
//
//        }
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","--------onTouchEvent----------");
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}