package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.fragment.AFragment;
import com.example.helloworld.fragment.ContainerActivity;
import com.example.helloworld.gridview.GridViewActivity;
import com.example.helloworld.jump.AActivity;
import com.example.helloworld.listview.ListViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;

    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView=findViewById(R.id.btn_textview);
        mBtnButton=findViewById(R.id.btn_button);
        mBtnEditText=findViewById(R.id.btn_edittext);
        mBtnRadioButton=findViewById(R.id.btn_radiobutton);
        mBtnCheckBox=findViewById(R.id.btn_checkbox);
        mBtnImageView=findViewById(R.id.btn_imageview);
        mBtnListView=findViewById(R.id.btn_listview);
        mBtnGridView=findViewById(R.id.btn_gridview);
        mBtnLifeCycle=findViewById(R.id.btn_lifecycle);
        mBtnJump=findViewById(R.id.btn_jump);
        mBtnFragment=findViewById(R.id.btn_fragment);

        mBtnRecyclerView=findViewById(R.id.btn_recyclerview);
        mBtnWebView=findViewById(R.id.btn_webview);
        mBtnToast=findViewById(R.id.btn_toast);
        mBtnDialog=findViewById(R.id.btn_dialog);
        mBtnProgress=findViewById(R.id.btn_progress);
        mBtnCustomDialog=findViewById(R.id.btn_customdialog);
        mBtnPopup=findViewById(R.id.btn_popup);

        setListener();
    }

    private void setListener(){
        OnClick onClick=new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);

        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopup.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    //?????????TextView????????????
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //?????????Button????????????
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    //?????????EditText????????????
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //?????????RadioButton????????????
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //?????????CheckBox????????????
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //?????????ImageView????????????
                    intent=new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    //?????????ListView????????????
                    intent=new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    //?????????GridView????????????
                    intent=new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    //?????????LifeCycle????????????
                    intent=new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    //?????????Jump????????????
                    intent=new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    //?????????Fragment????????????
                    intent=new Intent(UIActivity.this, ContainerActivity.class);
                    break;

                case R.id.btn_webview:
                    //?????????WebView????????????
                    intent=new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //?????????Toast????????????
                    intent=new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    //?????????Dialog????????????
                    intent=new Intent(UIActivity.this,DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    //?????????Progress????????????
                    intent=new Intent(UIActivity.this,ProgressActivity.class);
                    break;
                case R.id.btn_customdialog:
                    //?????????CustomDialog????????????
                    intent=new Intent(UIActivity.this,CustomDialogActivity.class);
                    break;
                case R.id.btn_popup:
                    //?????????PopupWindow????????????
                    intent=new Intent(UIActivity.this,PopupWindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}