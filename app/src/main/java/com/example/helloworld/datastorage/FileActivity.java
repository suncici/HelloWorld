package com.example.helloworld.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private final String mFileName="test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtName=findViewById(R.id.et_name);
        mBtnSave=findViewById(R.id.btn_save);
        mBtnShow=findViewById(R.id.btn_show);
        mTvContent=findViewById(R.id.tv_content);


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });

    }
    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream=null;
        try {
            //fileOutputStream= openFileOutput(mFileName,MODE_PRIVATE);//内部存储

            File dir= new File(Environment.getExternalStorageDirectory(),"skypan"); //外部存储
            if(!dir.exists()){
                dir.mkdirs();
            }
            File file=new File(dir,mFileName);
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                        fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //读取数据
    private String read(){
        FileInputStream fileInputStream=null;
        try {
           // fileInputStream=openFileInput(mFileName);//内部存储

            File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan",mFileName);
            fileInputStream=new FileInputStream(file);
            byte[] buff=new byte[1024];
            StringBuffer sb=new StringBuffer("");
            int len=0;
            while ((len=fileInputStream.read(buff))>0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}