package com.yujin.demo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yujin.demo.R;
import com.yujin.demo.activity.MyRecyclerViewAdapter;
import com.yujin.demo.model.DetailBodyItemBean;
import com.yujin.demo.presenter.DetailPresenterImpl;
import com.yujin.demo.view.BodyView;
import com.yujin.demo.view.HeaderView;
import com.yujin.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import xrecyclerview.DividerItemDecoration;

public class FragmentOne extends BaseFragment implements HeaderView, BodyView {
    public static final String TAG = FragmentOne.class.getSimpleName();

    private static FragmentOne instance = null;
    @Bind(R.id.recycler_view)
    public XRecyclerView mRecyclerView;
    public MyRecyclerViewAdapter mAdapter;
    public ArrayList<DetailBodyItemBean> datas = new ArrayList<>();
    private DetailPresenterImpl mDetailPresenterImpl;

    public static FragmentOne newInstance() {
        if (instance == null) {
            instance = new FragmentOne();
        }
        return instance;
    }

    //private FragmentOne(){}
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ArrayList<DetailBodyItemBean> newDatas = (ArrayList<DetailBodyItemBean>) msg.obj;
            datas.clear();//在收到新数据时一定记得将原数据清空,否则调用notifyDataSetChanged无法刷新列表
            datas.addAll(newDatas);
            if (mAdapter != null) {
                mAdapter.notifyDataSetChanged();
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailPresenterImpl = new DetailPresenterImpl(getActivity(), this);
        mDetailPresenterImpl.loadBody(0, 0);//加载RecyclerView的Body数据
        mDetailPresenterImpl.loadHeader(0, 0);//加载头像那一块区域的数据
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Log.i(TAG, "start load...");
                        mDetailPresenterImpl.loadBody(0, 0);//加载RecyclerView的Body数据
                        mDetailPresenterImpl.loadHeader(0, 0);//加载头像那一块区域的数据
                        Log.i(TAG, "stop load...");
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }
                }, 1000);
//                new Handler().postDelayed(new Runnable() {
//                    public void run() {
//
//                        mAdapter.notifyDataSetChanged();
//                        mRecyclerView.loadMoreComplete();
//                    }
//                }, 1000);
            }
        });
        return view;
    }

    public FragmentOne() {
        super();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void onFirstTimeLaunched() {
        super.onFirstTimeLaunched();
    }

    @Override
    protected void onSaveState(Bundle outState) {
        super.onSaveState(outState);
        outState.putSerializable("list", datas);
    }

    @Override
    protected void onRestoreState(Bundle savedInstanceState) {
        super.onRestoreState(savedInstanceState);
        datas = (ArrayList<DetailBodyItemBean>) savedInstanceState.get("list");
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void showLoadFailedMsg() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void loadData(ArrayList<DetailBodyItemBean> datas) {
        Message msg = mHandler.obtainMessage();
        msg.obj = datas;
        mHandler.sendMessage(msg);

    }

    @Override
    public void showDefaultData() {

    }

    @Override
    public void addData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
