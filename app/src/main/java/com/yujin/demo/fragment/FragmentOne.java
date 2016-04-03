package com.yujin.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
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

public class FragmentOne extends Fragment {
    public static final String TAG = FragmentOne.class.getSimpleName();

    private static FragmentOne instance = null;
    @Bind(R.id.recycler_view)
    XRecyclerView mRecyclerView;

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
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
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
