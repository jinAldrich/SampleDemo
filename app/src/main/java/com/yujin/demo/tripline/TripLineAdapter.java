package com.yujin.demo.tripline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * Created by yujin on 4/14/16.
 */
public class TripLineAdapter extends BaseRecyclerAdapter {
    public static final String TAG = TripLineAdapter.class.getSimpleName();

    private ArrayList<TripLineBean.TripLineBeanItemBean> list;
    private static Context mContext;
    private static final int TYPE_ADVERTISE = 0;           /*广告*/
    private static final int TYPE_TRAFFIC = 1;             /*交通和娱乐*/
    private static final int TYPE_ARITICLE_CHOICE = 2;     /*百代精选*/
    private static final int TYPE_TRIPLINE_RECOMMEND = 3;  /*路线推荐*/

    public TripLineAdapter(Context context, ArrayList list) {
        super(context);
        Log.i(TAG, "---TripLineAdapter---");
        mContext = context;
        this.list = list;
    }
    /**
     * 返回数据对应的类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        Log.i(TAG, "---getItemViewType---");
        int type = list.get(position).getType();
        Log.i(TAG, "type: " + type);
        return type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "---onCreateViewHolder---");
        Log.i(TAG, "viewType: " + viewType);
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_ADVERTISE:
                viewHolder = new AdvertiseViewHolder(new AdvertiseView(mContext));
                break;
            case TYPE_TRAFFIC:
                viewHolder = new TrafficViewHolder(LayoutInflater.from(mContext).
                        inflate(R.layout.tripline_traffic_entertain_view, parent, false));
                break;
            case TYPE_ARITICLE_CHOICE:
                viewHolder = new AriticleChoiceViewHolder(new AriticleChoiceView(mContext));
                break;
            case TYPE_TRIPLINE_RECOMMEND:
                viewHolder = new TripLineRecommendViewHolder(new TripLineRecommendView(mContext));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "---onBindViewHolder---");
        TripLineBean.TripLineBeanItemBean itemBean = list.get(position);
        if (null == itemBean)return;
        switch (getItemViewType(position)) {
            case TYPE_ADVERTISE:
                /*默认先不填数据*/
                break;
            case TYPE_TRAFFIC:
                /*默认先不填数据*/
                break;
            case TYPE_ARITICLE_CHOICE:
                AriticleChoiceViewHolder ariticleChoiceViewHolder = (AriticleChoiceViewHolder)holder;
                ariticleChoiceViewHolder.ariticleChoiceView.setData(itemBean.getTitle(), itemBean.getAriticleChoiceList());
                break;
            case TYPE_TRIPLINE_RECOMMEND:
                TripLineRecommendViewHolder recommendViewHolder = (TripLineRecommendViewHolder)holder;
                recommendViewHolder.tripLineRecommendView.setData(itemBean.getTitle(), itemBean.getTripLineRecommendList());
                break;
        }
    }

    /**
     * 广告ViewHolder
     */
    class AdvertiseViewHolder extends RecyclerView.ViewHolder {
        public AdvertiseViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 交通娱乐Viewholder
     */
    class TrafficViewHolder extends RecyclerView.ViewHolder {

        public TrafficViewHolder(View itemView) {
            super(itemView);

        }
    }

    /**
     * 文章精选ViewHolder
     */
    class AriticleChoiceViewHolder extends RecyclerView.ViewHolder {
        public AriticleChoiceView ariticleChoiceView;
        public AriticleChoiceViewHolder(View itemView) {
            super(itemView);
            ariticleChoiceView = (AriticleChoiceView)itemView;
        }
    }

    /**
     * 路线推荐ViewHolder
     */
    class TripLineRecommendViewHolder extends RecyclerView.ViewHolder {
        public TripLineRecommendView tripLineRecommendView;
        public TripLineRecommendViewHolder(View itemView) {
            super(itemView);
            tripLineRecommendView = (TripLineRecommendView)itemView;
        }
    }
}
