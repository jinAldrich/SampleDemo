package com.yujin.demo.activity;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yujin.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public static final String TAG = MyRecyclerViewAdapter.class.getSimpleName();

    private List<Integer> datas;
    private Context context;

    public MyRecyclerViewAdapter(Context context, List<Integer> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        ButterKnife.bind(this, view);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        //holder.itemView.setLayoutParams(params);
        //holder.itemTvTitle.setText(position + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
//    @Bind(R.id.item_iv)
//    ImageView itemIv;
//    @Bind(R.id.item_tv_title)
//    TextView itemTvTitle;
//    @Bind(R.id.item_tv_content)
//    TextView itemTvContent;
//    @Bind(R.id.cardview)
//    CardView cardview;
    public MyViewHolder(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
    }
}
