package com.example.helloworld.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvTitle=findViewById(R.id.tv_title);
        mBtnFinish=findViewById(R.id.btn_finish);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");
        mTvTitle.setText(name+","+number);
        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     Intent intent=new Intent(BActivity.this,AActivity.class);
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("title","我回来了。。。");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}