package com.example.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapter(Context context){
        this.mContext=context;
        this.mLayoutInflater=LayoutInflater.from(context);
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
        private TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv_gird);
            holder.textView=convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //赋值
        holder.textView.setText("花");
        Glide.with(mContext).load("https://th.bing.com/th/id/R61a07baf382803473650e7a3e0729f3d?rik=zuSxl5MXXSNxNg&riu=http%3a%2f%2fpic18.nipic.com%2f20111213%2f3101644_093708910330_2.jpg&ehk=m4PzLbzo3unWKq%2blmaczGj3gbUXFe6zovVuB2SNig8E%3d&risl=&pid=ImgRaw").into(holder.imageView);
        return convertView;
    }
}
