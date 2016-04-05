package com.yujin.demo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yujin.demo.R;
import com.yujin.demo.activity.MyRecyclerViewAdapter;
import com.yujin.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xrecyclerview.DividerItemDecoration;

public class FragmentOne extends Fragment {
    public static final String TAG = FragmentOne.class.getSimpleName();

    private static FragmentOne instance = null;
    @Bind(R.id.recycler_view)
    public XRecyclerView mRecyclerView;
    public MyRecyclerViewAdapter mAdapter;

    public static FragmentOne newInstance() {
        if (instance == null) {
            instance = new FragmentOne();
        }
        return instance;
    }

    //private FragmentOne(){}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "---onCreate---");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "---onCreateView---");
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        for (int i = 0; i < 15; i++) {
                            //listData.add("item" + i + "after " + refreshTime + " times of refresh");
                        }
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
                        for (int i = 0; i < 15; i++) {
                            //listData.add("item" + (i + listData.size()) );
                        }
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

        mAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "---onViewCreated---");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "---onActivityCreated---");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "---onStart---");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "---onResume---");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "---onPause---");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "---onStop---");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
