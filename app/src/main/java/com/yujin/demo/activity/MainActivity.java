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
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yujin.demo.BaseActivity;
import com.yujin.demo.R;
import com.yujin.demo.fragment.FragmentOne;
import com.yujin.demo.fragment.FragmentThree;
import com.yujin.demo.fragment.FragmentTwo;
import com.yujin.demo.utils.BitmapUtils;
import com.yujin.demo.utils.CircleDrawable;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView head;
    private FrameLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_main2);
        initViews();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);//设置ToolBar的titl颜色
        //mToolbar.setLogo(R.mipmap.ic_launcher);// App Logo
        mToolbar.setTitle("");// Title
        //mToolbar.setSubtitle("Sub title");// Sub Title
        //mToolbar.setNavigationIcon(R.mipmap.imag_left);//Navigation Icon
        setSupportActionBar(mToolbar);

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "");
        supportPostponeEnterTransition();

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //mCollapsingToolbarLayout.setTitle("标题");
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        mCollapsingToolbarLayout.setContentScrimColor(R.color.material_blue_grey_800);
        mCollapsingToolbarLayout.setStatusBarScrimColor(R.color.colorPrimary);
        //mCollapsingToolbarLayout.seton
    }

    private void initViews() {
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(FragmentOne.newInstance(), "TabOne");//添加Fragment
        viewPagerAdapter.addFragment(FragmentTwo.newInstance(), "TabTwo");
        viewPagerAdapter.addFragment(FragmentThree.newInstance(), "TabThree");
        mViewPager.setAdapter(viewPagerAdapter);//设置适配器

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("TabOne"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("TabTwo"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TabThree"));
        mTabLayout.setupWithViewPager(mViewPager);//给TabLayout设置关联ViewPager

        bg = (FrameLayout) findViewById(R.id.head_bg);
        head = (ImageView) findViewById(R.id.head);

        head.setImageDrawable(new CircleDrawable(BitmapFactory.decodeResource(getResources(), R.mipmap.small)));
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

    private void initHeadBackground() {
        Drawable drawable = getResources().getDrawable(R.mipmap.rocko);
        Bitmap srcBitmap = BitmapUtils.drawable2Bitmap(drawable);

        /*先黑白图片*/
        float[] src = new float[]{
                0.28F, 0.60F, 0.40F, 0, 0,
                0.28F, 0.60F, 0.40F, 0, 0,
                0.28F, 0.60F, 0.40F, 0, 0,
                0, 0, 0, 1, 0,
        };
        ColorMatrix cm = new ColorMatrix(src);
//        cm.setSaturation(0.0f);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        Bitmap resultBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(100);
        //paint.setColorFilter(f);
        canvas.drawBitmap(srcBitmap, 0, 0, paint);
        /*后模糊图片*/
        Bitmap bB = BitmapUtils.blurBitmap(getApplicationContext(), resultBitmap, 15.5f);

        bg.setBackgroundDrawable(new BitmapDrawable(getResources(), bB));
    }

}
