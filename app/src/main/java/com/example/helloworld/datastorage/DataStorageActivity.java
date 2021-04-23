package com.example.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSharedPreferences,mBtnFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences=findViewById(R.id.btn_sharedPreferences);
        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile=findViewById(R.id.btn_file);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.btn_sharedPreferences:
                intent=new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent=new Intent(DataStorageActivity.this,FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}