package com.yujin.demo.tripline;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yujin.demo.R;
import com.yujin.demo.base.adapter.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 路线推荐
 * Created by yujin on 4/14/16.
 */
public class TripLineRecommendView extends RelativeLayout {

    private static final String TAG = TripLineRecommendView.class.getSimpleName();

    private Context mContext;
    /**
     * 标题,如[路线推荐]
     */
    private TextView mTitle;
    /**
     * 文章列表
     */
    public RecyclerView mRecyclerView;

    public RecommendViewAdapter RecommendViewAdapter;

    public TripLineRecommendView(Context context) {
        this(context, null);
    }

    public TripLineRecommendView(Context context, AttributeSet set) {
        this(context, set, 0);
    }

    public TripLineRecommendView(Context context, AttributeSet set, int defineStyle) {
        super(context, set, defineStyle);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.tripline_recommend_view, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_recommend);
        mTitle = (TextView) findViewById(R.id.tv_title);
    }

    /**
     * @param title 标题
     * @param list  数据集
     */
    public void setData(String title, List<TripLineRecommendBean> list) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTitle.setText(title);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(RecommendViewAdapter == null ?
                    RecommendViewAdapter = new RecommendViewAdapter(mContext) : RecommendViewAdapter);
            RecommendViewAdapter.updateItems(list);
        }
    }

    /**
     * 路线推荐适配器
     */
    public class RecommendViewAdapter extends BaseRecyclerAdapter<TripLineRecommendBean> {

        private Context mContext;

        public RecommendViewAdapter(Context context) {
            super(context);
            Log.i(TAG, "---RecommendViewAdapter---");
            mContext = context;
        }

        @Override
        public int getItemCount() {
            Log.i(TAG, "---getItemCount---");
            Log.i(TAG, "getList().size(): " + getList().size());
            return getList().size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.i(TAG, "---onCreateViewHolder---");
            RecyclerView.ViewHolder viewHolder = new RecommendItemViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.tripline_recommend_item_view, null));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.i(TAG, "---onBindViewHolder---");
            RecommendItemViewHolder recommendViewHolder = (RecommendItemViewHolder) holder;
            TripLineRecommendBean bean = getList().get(position);
            recommendViewHolder.tvFromLocation.setText(bean.getFromLocation());
            recommendViewHolder.tvRoute.setText(bean.getRoute());
            recommendViewHolder.tvTripType.setText(bean.getTripType());
            recommendViewHolder.tvTripArea.setText(bean.getTripArea());
            recommendViewHolder.tvTripDate.setText(bean.getTripDate());

        }

        public class RecommendItemViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.view)
            View view;
            @Bind(R.id.tv_title)
            TextView tvTitle;
            @Bind(R.id.icon)
            SimpleDraweeView icon;
            @Bind(R.id.tv_fromLocation)
            TextView tvFromLocation;
            @Bind(R.id.tv_route)
            TextView tvRoute;
            @Bind(R.id.tv_trip_area)
            TextView tvTripArea;
            @Bind(R.id.tv_trip_type)
            TextView tvTripType;
            @Bind(R.id.tv_trip_date)
            TextView tvTripDate;
            @Bind(R.id.article_classic_choice)
            LinearLayout articleClassicChoice;

            public RecommendItemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        /**
         * 输出测试数据,检查是否有数据过来
         *
         * @param list
         */
        private void printList(ArrayList<AriticleChoiceBean> list) {
            Log.i(TAG, "list.size: " + list.size());
            for (int i = 0; i < list.size(); i++) {
                Log.i(TAG, list.get(i).toString());
            }
        }

    }
}
