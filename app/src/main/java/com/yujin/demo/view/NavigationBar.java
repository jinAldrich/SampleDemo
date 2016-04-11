package com.yujin.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.yujin.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yujin on 4/11/16.
 */
public class NavigationBar extends LinearLayout {
    public static final String TAG = NavigationBar.class.getSimpleName();
    @Bind(R.id.navi_head)
    ImageView naviHead;
    @Bind(R.id.navi_head_container)
    FrameLayout naviHeadContainer;
    @Bind(R.id.navi_more)
    ImageView naviMore;
    @Bind(R.id.navi_title_recent)
    ImageView naviTitleRecent;
    @Bind(R.id.navi_title_parent)
    FrameLayout naviTitleParent;
    @Bind(R.id.top_refresh)
    ImageView topRefresh;
    @Bind(R.id.navi_title_click_layout)
    RelativeLayout naviTitleClickLayout;
    @Bind(R.id.title_bar)
    RelativeLayout titleBar;
    @Bind(R.id.navigation_bar)
    RelativeLayout navigationBar;

    private Context mContext;

    public NavigationBar(Context context) {
        this(context, null);
    }

    public NavigationBar(Context context, AttributeSet set) {
        this(context, set, 0);
    }

    public NavigationBar(Context context, AttributeSet set, int defineStyle) {
        super(context, set, defineStyle);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.navigationbar, null);
        ButterKnife.bind(this, view);
        addView(view);
    }
}
