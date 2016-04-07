package com.yujin.demo.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yujin.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yujin on 16/4/5.
 */
public class BDToolBar extends Toolbar {
    public static final String TAG = BDToolBar.class.getSimpleName();
    @Bind(R.id.iv_toolbar_back)
    ImageView ivBack;
    @Bind(R.id.ll_toolbar_left)
    LinearLayout llLeft;
    @Bind(R.id.iv_toolbar_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_toolbar_title)
    TextView tvTitle;
    @Bind(R.id.ll_toolbar_center)
    LinearLayout llCenter;
    @Bind(R.id.ll_toolbar_right)
    LinearLayout llRight;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private Activity mContext;
    /*视图构造器*/
    private LayoutInflater mInflater;

    public BDToolBar(Activity context) {
        super(context);
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.toolbar, this, false);
        ButterKnife.bind(this, view);
    }

    public BDToolBar(Activity context, AttributeSet attr) {
        super(context, attr);
        mContext = context;
    }

    public BDToolBar(Activity context, AttributeSet attr, int defineStyle) {
        super(context, attr, defineStyle);
        mContext = context;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @OnClick({R.id.iv_toolbar_back, R.id.iv_toolbar_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                mContext.finish();
                break;
            case R.id.iv_toolbar_icon:
                break;
        }
    }
}
