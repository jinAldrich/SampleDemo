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
import android.widget.TextView;

import com.baidai.baidaitravel.R;
import com.baidai.baidaitravel.ui.base.adapter.BaseRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 百代文章精选
 * Created by yujin on 4/14/16.
 */
public class AriticleChoiceView extends LinearLayout {
    private static final String TAG = AriticleChoiceView.class.getSimpleName();

    private Context mContext;
    /**
     * 标题,如[百代精选]
     */
    private TextView mTitle;
    /**
     * 文章列表
     */
    public RecyclerView mRecyclerView;

    public AriticleChoiceViewAdapter mAriticleChoiceViewAdapter;

    public AriticleChoiceView(Context context) {
        this(context, null);
    }

    public AriticleChoiceView(Context context, AttributeSet set) {
        this(context, set, 0);
    }

    public AriticleChoiceView(Context context, AttributeSet set, int defineStyle) {
        super(context, set, defineStyle);
        mContext = context;
        initView();
    }

    private void initView() {
        int width = Math.min(
                getResources().getDisplayMetrics().widthPixels,
                getResources().getDisplayMetrics().heightPixels);
        LayoutInflater.from(mContext).inflate(R.layout.tripline_ariticlechoice_view, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_article);
        mRecyclerView.getLayoutParams().width = width;
        mRecyclerView.getLayoutParams().height = width * 3 + 80;
        mTitle = (TextView) findViewById(R.id.tv_title);
    }

    /**
     * @param title 标题
     * @param list 数据集
     */
    public void setData(String title, List<AriticleChoiceBean> list) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTitle.setText(title);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(mAriticleChoiceViewAdapter == null ?
                    mAriticleChoiceViewAdapter = new AriticleChoiceViewAdapter(mContext) : mAriticleChoiceViewAdapter);
            mAriticleChoiceViewAdapter.updateItems(list);
        }
    }

    /**
     * 百代精选适配器
     */
    public class AriticleChoiceViewAdapter extends BaseRecyclerAdapter<AriticleChoiceBean> {

        private Context mContext;
        public AriticleChoiceViewAdapter(Context context) {
            super(context);
            Log.i(TAG, "---AriticleChoiceViewAdapter---");
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
            View view = LayoutInflater.from(mContext).inflate(R.layout.tripline_ariticle_choice_item_view, null);
            RecyclerView.ViewHolder viewHolder = new AriticleChoiceItemViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.i(TAG, "---onBindViewHolder---");
            AriticleChoiceItemViewHolder ariticleChoiceViewHolder = (AriticleChoiceItemViewHolder) holder;
            AriticleChoiceBean bean = getList().get(position);
            ariticleChoiceViewHolder.tvArticleTitle.setText(bean.getTitle());
            ariticleChoiceViewHolder.tvContent.setText(bean.getContent());

        }

        public class AriticleChoiceItemViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.icon)
            public SimpleDraweeView icon;
            @Bind(R.id.tv_article_title)
            public TextView tvArticleTitle;
            @Bind(R.id.tv_content)
            public TextView tvContent;
            @Bind(R.id.article_classic_choice)
            public LinearLayout articleClassicChoice;
            public AriticleChoiceItemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }

}
