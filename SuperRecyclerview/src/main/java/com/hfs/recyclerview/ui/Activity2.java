package com.hfs.recyclerview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.hfs.recyclerview.R;
import com.hfs.recyclerview.adapter.InfoAdapter;
import com.hfs.recyclerview.bean.InfoBean;
import com.hfs.recyclerview.view.BaseAdapter;
import com.hfs.recyclerview.view.PullBaseView;
import com.hfs.recyclerview.view.PullRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity implements BaseAdapter.OnItemClickListener, BaseAdapter.OnItemLongClickListener,
        BaseAdapter.OnViewClickListener, PullBaseView.OnRefreshListener {

    PullRecyclerView recyclerView;
    List<Object> mDatas;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        initData();
        initRecyclerView();
    }

    protected void initData() {
        mDatas = new ArrayList<>();
        List<Object> imageList = new ArrayList<>();
        imageList.add("http://avatar.csdn.net/5/9/B/1_greathfs.jpg");
        imageList.add("http://img2.3lian.com/2014/f6/72/d/92.jpg");
        imageList.add("http://i.k1982.com/design_img/201109/201109011617318631.jpg");
        imageList.add("http://a2.att.hudong.com/71/04/300224654811132504044925945_950.jpg");
        imageList.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1402/12/c1/31189058_1392186616852.jpg");
        imageList.add("http://img2.3lian.com/2014/f6/173/d/51.jpg");
        for (int i = 1; i < 30; i++) {
            InfoBean info = new InfoBean();
            info.setText("测试数据" + (i < 10 ? "0" + i : i));
            info.setImgList(imageList);
            mDatas.add(info);
        }
    }

    private void initRecyclerView() {
        recyclerView = (PullRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoAdapter = new InfoAdapter(this, mDatas, this);
        infoAdapter.setOnItemClickListener(this);
        infoAdapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(infoAdapter);
    }

    /**
     * 子View点击事件
     *
     * @param position item position
     * @param viewtype 点击的view的类型，调用时根据不同的view传入不同的值加以区分
     */
    @Override
    public void onViewClick(int position, int viewtype) {
        switch (viewtype) {
            case 1://赞
                Toast.makeText(Activity2.this, "赞-position>>" + position, Toast.LENGTH_SHORT).show();
                break;
            case 2://评论
                Toast.makeText(Activity2.this, "评论-position>>" + position, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * item点击事件
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {
        Toast.makeText(Activity2.this, "点击-position>>" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * item长按事件
     *
     * @param position
     */
    @Override
    public void onItemLongClick(int position) {
        Toast.makeText(Activity2.this, "长按-position>>" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * 上拉加载
     *
     * @param view
     */
    @Override
    public void onFooterRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                InfoBean info = new InfoBean();
                info.setText("加载更多");
                mDatas.add(info);
                infoAdapter.notifyDataSetChanged();
                recyclerView.onFooterRefreshComplete();
            }
        }, 1500);
    }

    /**
     * 下拉刷新
     *
     * @param view
     */
    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                InfoBean info = new InfoBean();
                info.setText("刷新更多");
                mDatas.add(0, info);
                infoAdapter.notifyDataSetChanged();
                recyclerView.onHeaderRefreshComplete();
            }
        }, 1500);
    }


}
