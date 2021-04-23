package com.example.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;

    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context){
         mContext=context;
         mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        private ImageView imageView;
        private TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv);
            holder.tvTitle=convertView.findViewById(R.id.tv_title);
            holder.tvTime=convertView.findViewById(R.id.tv_time);
            holder.tvContent=convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2021-08-08");
        holder.tvContent.setText("这是内容啊");
        Glide.with(mContext).load("https://avatar.csdnimg.cn/C/5/1/1_u012117917.jpg").into(holder.imageView);
        return convertView;
    }
}
