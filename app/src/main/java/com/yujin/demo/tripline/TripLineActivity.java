package com.yujin.demo.tripline;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidai.baidaitravel.R;
import com.baidai.baidaitravel.ui.base.activity.BaseActivity;
import com.baidai.baidaitravel.widget.xrecycleview.ProgressStyle;
import com.baidai.baidaitravel.widget.xrecycleview.XRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TripLineActivity extends BaseActivity {
    public static final String TAG = TripLineActivity.class.getSimpleName();
    private Context mContext;
    @Bind(R.id.rv_list_tripline)
    public XRecyclerView mXRecyclerView;
    @Bind(R.id.empty_progressbar)
    ProgressBar emptyProgressbar;
    @Bind(R.id.empty_text)
    TextView emptyText;
    @Bind(R.id.empty_load)
    LinearLayout emptyLoad;
    @Bind(R.id.empty_button)
    Button emptyButton;
    @Bind(android.R.id.empty)
    RelativeLayout empty;

    public TripLineAdapter mTripLineAdapter;
    public ArrayList<TripLineBean.TripLineBeanItemBean> tripLineBeanItems = new ArrayList<TripLineBean.TripLineBeanItemBean>();

    private static final int TYPE_ADVERTISE = 0;           /*广告*/
    private static final int TYPE_TRAFFIC = 1;             /*交通和娱乐*/
    private static final int TYPE_ARITICLE_CHOICE = 2;     /*百代精选*/
    private static final int TYPE_TRIPLINE_RECOMMEND = 3;  /*路线推荐*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_line);
        ButterKnife.bind(this);
        createData();
        mContext = this;
        if (null != mXRecyclerView) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mXRecyclerView.setLayoutManager(linearLayoutManager);
            mXRecyclerView.setHasFixedSize(true);
            mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
            Log.i(TAG, "tripLineBeanItems.size(): " + tripLineBeanItems.size());
            mXRecyclerView.setAdapter(mTripLineAdapter == null ? mTripLineAdapter = new TripLineAdapter(this, tripLineBeanItems) : mTripLineAdapter);
            //隐藏下拉加载更多
            mXRecyclerView.setLoadingMoreEnabled(false);
            mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    //上拉刷新 TODO 待服务器搭好替换
                    //destinationPresenter.testAddData();
                    //destinationPresenter.loadData(1);
                    mXRecyclerView.refreshComplete();
                }
                @Override
                public void onLoadMore() {
                    //下拉加载更多
                    mXRecyclerView.loadMoreComplete();
                }
            });

        }

    }


    /**
     * 造测试用的假数据
     */
    private void createData() {
        TripLineBean.TripLineBeanItemBean bean0 = new TripLineBean.TripLineBeanItemBean();
        //广告
        ArrayList<ImageView> ivs=new ArrayList<ImageView>();
        ImageView iv1=new ImageView(TripLineActivity.this);
        iv1.setBackgroundResource(R.drawable.new_homepage_jiujiang_bg);
        ivs.add(iv1);
        ImageView iv2=new ImageView(TripLineActivity.this);
        iv2.setBackgroundResource(R.drawable.new_homepage_anshan_bg);
        ivs.add(iv2);
        ImageView iv3=new ImageView(TripLineActivity.this);
        iv3.setBackgroundResource(R.drawable.new_homepage_bg);
        ivs.add(iv3);
        ImageView iv4=new ImageView(TripLineActivity.this);
        iv4.setBackgroundResource(R.drawable.new_homepage_anshan_bg);
        ivs.add(iv4);
        bean0.setType(0);
        bean0.getAdvertiseImage().addAll(ivs);

        //交通和本地玩乐
        TripLineBean.TripLineBeanItemBean bean1 = new TripLineBean.TripLineBeanItemBean();
        bean1.setType(1);

        //百代文章精选
        TripLineBean.TripLineBeanItemBean bean2 = new TripLineBean.TripLineBeanItemBean();
        ArrayList<AriticleChoiceBean> ariticleChoiceList = bean2.getAriticleChoiceList();
        for (int i = 0; i < 5; i++) {
            AriticleChoiceBean bean = new AriticleChoiceBean();
            bean.setTitle("国家人文历史");
            bean.setContent("北京故宫博物院建立于1925年10月10日，位于北京故宫紫禁城内。是在明朝、清朝两代皇宫及其收藏的基础上建立起来的中国综合性博物馆，也是中国最大的古代文化艺术博物馆，其文物收藏主要来源于清代宫中旧藏，是第一批全国爱国主义教育示范基地。");
            ariticleChoiceList.add(bean);
        }
        bean2.setType(2);
        bean2.setTitle("百代精选");

        //路线推荐
        TripLineBean.TripLineBeanItemBean bean3 = new TripLineBean.TripLineBeanItemBean();
        ArrayList<TripLineRecommendBean> tripBeanRecommendBeanArrayList = bean3.getTripLineRecommendList();
        for (int i = 0; i < 5; i++) {
            TripLineRecommendBean bean = new TripLineRecommendBean();
            bean.setFromLocation("北京出发");
            bean.setRoute("行程3天");
            bean.setTripArea("[中国]");
            bean.setTripType("[海景岛恋]");
            bean.setTripDate("[双飞5日]");
            tripBeanRecommendBeanArrayList.add(bean);
        }
        bean3.setType(3);
        bean3.setTitle("路线推荐");

        tripLineBeanItems.add(bean0);
        tripLineBeanItems.add(bean1);
        tripLineBeanItems.add(bean2);
        tripLineBeanItems.add(bean3);
    }

}
