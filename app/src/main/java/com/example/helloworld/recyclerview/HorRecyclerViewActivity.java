package com.example.helloworld.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.R;

public class HorRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvHor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
        mRvHor=findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayout=new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHor.setLayoutManager(linearLayout);
        mRvHor.addItemDecoration(new HorRecyclerViewActivity.MyDecoration());
        mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this,"点击了："+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}