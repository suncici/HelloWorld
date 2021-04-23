package com.example.helloworld.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.helloworld.R;

public class BroadcastActivity2 extends AppCompatActivity {

    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast2);
        mBtn=findViewById(R.id.btn_click);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.skypan.update");
                //intent.setComponent(new ComponentName("com.example.helloworld.broadcast","com.example.helloworld.broadcast.BroadcastActivity"));
                sendBroadcast(intent);
            }
        });
    }
}