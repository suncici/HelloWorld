package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog=findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确定要删除订单吗？")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"取消中。。。");
                            }
                        }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfrim(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"确定中。。。");
                            }
                        }).show();

            }
        });
    }
}