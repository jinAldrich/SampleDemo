package com.yujin.demo.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yujin.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    public static final String TAG = MyViewPagerAdapter.class.getSimpleName();

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentsTitles = new ArrayList<>();

    @Bind(R.id.tab_item_title)
    public TextView tabItemTitle;
    @Bind(R.id.tab_item_number)
    public TextView tabItemNumber;

    private Context mContext;
    private FragmentManager mFragmentManager;
    public MyViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFragmentManager = fm;
        mContext = context;
    }

    /**
     * @param fragment      添加Fragment
     * @param fragmentTitle Fragment的标题，即TabLayout中对应Tab的标题
     */
    public void addFragment(Fragment fragment, String fragmentTitle) {
        mFragments.add(fragment);
        mFragmentsTitles.add(fragmentTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentsTitles.get(position);//TabLayout中对应Tab的标题
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item, null);
        ButterKnife.bind(this, view);
        tabItemTitle.setText(mFragmentsTitles.get(position));
        tabItemNumber.setText("25");
        return view;
    }
}
