package com.yujin.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yujin.demo.R;
import com.yujin.demo.activity.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {
    private static FragmentTwo instance=null;
    public static FragmentTwo newInstance() {
        if(instance==null){
            instance= new FragmentTwo();
        }
        return instance;
    }
    //private FragmentTwo(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.fragment_tv);
        mTextView.setText("这是第二个Fragment");
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
        return view;
    }


}
