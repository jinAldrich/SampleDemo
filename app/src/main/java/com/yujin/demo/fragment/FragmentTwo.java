package com.yujin.demo.fragment;

import android.os.Bundle;
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

public class FragmentTwo extends Fragment {
    public static final String TAG = FragmentTwo.class.getSimpleName();

    private static FragmentTwo instance = null;
    @Bind(R.id.recycler_view)
    public XRecyclerView mRecyclerView;

    public static FragmentTwo newInstance() {
        if (instance == null) {
            instance = new FragmentTwo();
        }
        return instance;
    }
    //private FragmentTwo(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "---onCreate---");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "---onCreateView---");
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        //mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "---onViewStateRestored---");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "---onActivityCreated---");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "---onSaveInstanceState---");
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
    public void onResume() {
        super.onResume();
        Log.i(TAG, "---onResume---");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "---onStart---");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
