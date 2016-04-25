package com.yujin.demo.tripline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yujin.demo.R;
import com.yujin.widget.autoviewpager.AutoSlideViewpagerAndPoint;

import java.util.ArrayList;

/**
 * 头部广告
 * Created by yujin on 4/14/16.
 */
public class AdvertiseView extends LinearLayout{
    public static final String TAG = AdvertiseView.class.getSimpleName();
    public Context mContext;
    public LinearLayout ll;
    public AdvertiseView(Context context) {
        this(context, null);
    }

    public AdvertiseView(Context context, AttributeSet set) {
        this(context, set, 0);
    }

    public AdvertiseView(Context context, AttributeSet set, int defineStyle) {
        super(context, set, defineStyle);
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.tripline_advertise_view, null);
        addView(view);

        ll = (LinearLayout) view.findViewById(R.id.autoViewPagerContainer);
        ArrayList<ImageView> lists = getImages();
        final AutoSlideViewpagerAndPoint vp = new AutoSlideViewpagerAndPoint(mContext, lists);
        vp.startRoll(true);
        vp.setOnPagerClick(new AutoSlideViewpagerAndPoint.onPagerClick() {
            @Override
            public void pagerDoSomething(View imageView, int positon) {
                Toast.makeText(mContext, "" + positon, Toast.LENGTH_SHORT).show();
            }
        });
        vp.setTIME(3000);
        vp.setOnPagerScrolled(new AutoSlideViewpagerAndPoint.onPagerScrolled() {

            @Override
            public void pagerScrolled(int arg0, float arg1, int arg2) {
//             Toast.makeText(MainActivity.this, ""+arg0, Toast.LENGTH_SHORT).show();
            }
        });
        vp.setmGravityType(AutoSlideViewpagerAndPoint.GRAVITY_LINE_CENTER);
        //vp.setAnimationType(Zhang_ViewPagerAndPoint.ANIMATION_DepthPageTransformer);
        //所有的操作都应该在setViewPagerAndPoint之前完成
        FrameLayout fl = vp.setViewPagerAndPoint();
        ll.addView(fl);
    }

    private ArrayList<ImageView> getImages() {
        ArrayList<ImageView> ivs=new ArrayList<ImageView>();
//        ImageView iv1=new ImageView(mContext);
//        iv1.setBackgroundResource(R.drawable.new_homepage_jiujiang_bg);
//        ivs.add(iv1);
//        ImageView iv2=new ImageView(mContext);
//        iv2.setBackgroundResource(R.drawable.new_homepage_anshan_bg);
//        ivs.add(iv2);
//        ImageView iv3=new ImageView(mContext);
//        iv3.setBackgroundResource(R.drawable.new_homepage_bg);
//        ivs.add(iv3);
//        ImageView iv4=new ImageView(mContext);
//        iv4.setBackgroundResource(R.drawable.new_homepage_anshan_bg);
//        ivs.add(iv4);
        return ivs;
    }
}
