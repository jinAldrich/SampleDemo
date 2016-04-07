package com.yujin.demo.activity;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yujin.demo.R;
import com.yujin.demo.model.DetailBodyItemBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    public static final String TAG = MyRecyclerViewAdapter.class.getSimpleName();

    private List<DetailBodyItemBean> datas;
    private Context context;

    public MyRecyclerViewAdapter(Context context, List<DetailBodyItemBean> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "--onCreateViewHolder---");
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        //ButterKnife.bind(this, view);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "--onBindViewHolder---");
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        DetailBodyItemBean bean = datas.get(position);
        holder.itemTvDay.setText(bean.day);
        holder.itemTvMonth.setText(bean.month);
        holder.itemTvTitle.setText(bean.title);
        holder.itemTvContent.setText(bean.profile);
        //holder.itemView.setLayoutParams(params);
        //holder.itemTvTitle.setText(position + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.itme_tv_day)
        TextView itemTvDay;
        @Bind(R.id.itme_tv_month)
        TextView itemTvMonth;
        @Bind(R.id.item_iv)
        ImageView itemIv;
        @Bind(R.id.item_tv_title)
        TextView itemTvTitle;
        @Bind(R.id.item_tv_content)
        TextView itemTvContent;
        @Bind(R.id.cardview)
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
