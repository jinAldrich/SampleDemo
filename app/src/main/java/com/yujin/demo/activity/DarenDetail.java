package com.yujin.demo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yujin.demo.BaseActivity;
import com.yujin.demo.R;
import com.yujin.demo.fragment.FragmentOne;
import com.yujin.demo.fragment.FragmentThree;
import com.yujin.demo.fragment.FragmentTwo;
import com.yujin.demo.utils.BitmapUtils;
import com.yujin.demo.utils.CircleDrawable;
import com.yujin.demo.view.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DarenDetail extends BaseActivity {
    public static final String TAG = DarenDetail.class.getSimpleName();
    @Bind(R.id.civ_head)
    CircleImageView civHead;
    @Bind(R.id.ll_header_networkname)
    TextView llHeaderNetworkname;
    @Bind(R.id.ll_header_impression)
    LinearLayout llHeaderImpression;
    @Bind(R.id.ll_header_motto)
    TextView llHeaderMotto;
    @Bind(R.id.head_bg)
    LinearLayout headBg;
    @Bind(R.id.iv_toolbar_back)
    ImageView ivToolbarBack;
    @Bind(R.id.ll_toolbar_left)
    LinearLayout llToolbarLeft;
    @Bind(R.id.iv_toolbar_icon)
    CircleImageView ivToolbarIcon;
    @Bind(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @Bind(R.id.ll_toolbar_center)
    LinearLayout llToolbarCenter;
    @Bind(R.id.ll_toolbar_right)
    LinearLayout llToolbarRight;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_daren_detail);
        ButterKnife.bind(this);
        initViews();

        mToolbar.setTitleTextColor(Color.WHITE);//设置ToolBar的titl颜色
        setSupportActionBar(mToolbar);

        ViewCompat.setTransitionName(mAppBarLayout, "");
        supportPostponeEnterTransition();

        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    setXRecyclerViewRefresh(true);
                } else {
                    setXRecyclerViewRefresh(false);
                }
                int maxScroll = appBarLayout.getTotalScrollRange();
                float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
                Log.i(TAG, "percentage: " + percentage);
                //llToolbarCenter.setAlpha(percentage);
            }
        });
    }

    private void initViews() {
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), this);
        fragmentOne = FragmentOne.newInstance();
        fragmentTwo = FragmentTwo.newInstance();
        fragmentThree = FragmentThree.newInstance();
        viewPagerAdapter.addFragment(fragmentOne, "文章");//添加Fragment
        viewPagerAdapter.addFragment(fragmentTwo, "评论");
        viewPagerAdapter.addFragment(fragmentThree, "回复");
        mViewpager.setAdapter(viewPagerAdapter);//设置适配器

        mTabLayout.addTab(mTabLayout.newTab());//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setupWithViewPager(mViewpager);//给TabLayout设置关联ViewPager

        civHead.setImageDrawable(new CircleDrawable(BitmapFactory.decodeResource(getResources(), R.mipmap.small)));
        initHeadBackground();
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    @OnClick({R.id.iv_toolbar_back, R.id.iv_toolbar_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                finish();
                break;
            case R.id.iv_toolbar_icon:
                break;
        }
    }

    /**
     * 模糊背景处理
     *
     */
    private void initHeadBackground() {
        Drawable drawable = getResources().getDrawable(R.mipmap.rocko);
        Bitmap srcBitmap = BitmapUtils.drawable2Bitmap(drawable);
        Bitmap resultBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(100);
        canvas.drawBitmap(srcBitmap, 0, 0, paint);
        /*后模糊图片*/
        Bitmap bB = BitmapUtils.blurBitmap(getApplicationContext(), resultBitmap, 24.5f);
        headBg.setBackgroundDrawable(new BitmapDrawable(getResources(), bB));
    }

    /**
     * 设置XRecyclerView是否可下拉刷新
     *
     * @param refresh
     */
    public void setXRecyclerViewRefresh(boolean refresh) {
        if (fragmentOne.mRecyclerView != null) {
            fragmentOne.mRecyclerView.setPullRefreshEnabled(refresh);
        }
        if (fragmentTwo.mRecyclerView != null) {
            fragmentTwo.mRecyclerView.setPullRefreshEnabled(refresh);
        }
        if (fragmentThree.mRecyclerView != null) {
            fragmentThree.mRecyclerView.setPullRefreshEnabled(refresh);
        }
    }

    /**
     * 设置Toolbar上标题动画
     * @param view
     */
    public void  setToolbarTitleAnimation(View view) {
//        TranslateAnimation translateAnimation = new TranslateAnimation();
    }

}
