package com.example.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;
    private String title,message,cancel,confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context){
        super(context);
    }

    public CustomDialog(@NonNull Context context,int themeId){
        super(context,themeId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener=cancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener confirmListener) {
        this.confirm = confirm;
        this.confirmListener=confirmListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager m=getWindow().getWindowManager();
        Display d=m.getDefaultDisplay();
        WindowManager.LayoutParams p=getWindow().getAttributes();
        Point size=new Point();
        d.getSize(size);
        p.width=(int)(size.x*0.8);//设置dialog的宽度为当前手机屏幕的宽度
        getWindow().setAttributes(p);
        getWindow().setBackgroundDrawableResource(R.drawable.layout_custom_dialog);

        mTvTitle=findViewById(R.id.tv_title);
        mTvMessage=findViewById(R.id.tv_message);
        mTvCancel=findViewById(R.id.tv_cancel);
        mTvConfirm=findViewById(R.id.tv_confirm);
        if(!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mTvTitle.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTvTitle.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTvTitle.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.tv_title:
//                break;
//            case R.id.tv_message:
//                break;
            case R.id.tv_cancel:
                if(cancelListener!=null){
                    cancelListener.onCancel(this);
                }
                break;
            case R.id.tv_confirm:
                if(confirmListener!=null){
                    confirmListener.onConfrim(this);
                }
                break;

        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void onConfrim(CustomDialog dialog);
    }
}
