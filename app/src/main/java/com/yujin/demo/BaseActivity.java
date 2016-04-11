package com.yujin.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;


public class BaseActivity extends AppCompatActivity {
    private   FrameLayout baseContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitleTextColor(Color.WHITE);//设置ToolBar的titl颜色
//        setSupportActionBar(mToolbar);


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_base);
        //初始化根布局容器
        baseContainer = (FrameLayout) findViewById(R.id.base_container);
        ViewGroup.inflate(this, layoutResID, baseContainer);

        ButterKnife.bind(this);
    }
}
