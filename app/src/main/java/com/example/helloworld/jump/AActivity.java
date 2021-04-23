package com.example.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump=findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式1跳转
                Intent intent=new Intent(AActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","好的");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,0);

                //显式2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式3
//                Intent intent=new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloworld.jump.BActivity");
//                startActivity(intent);

                //显示4
//                Intent intent=new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式
//                Intent intent=new Intent();
//                intent.setAction("android.intent.action.jumpB");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}