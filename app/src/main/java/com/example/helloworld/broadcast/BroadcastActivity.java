package com.example.helloworld.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class BroadcastActivity extends AppCompatActivity {

    private Button mBtn1;
    private TextView mTvTest;
    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        mBtn1=findViewById(R.id.btn1);
        mTvTest=findViewById(R.id.tv_test);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadcastActivity.this,BroadcastActivity2.class);
                startActivity(intent);
            }
        });

        mBroadcast=new MyBroadcast();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.skypan.update");
        registerReceiver(mBroadcast,intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.skypan.update":
                    mTvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcast);
    }
}