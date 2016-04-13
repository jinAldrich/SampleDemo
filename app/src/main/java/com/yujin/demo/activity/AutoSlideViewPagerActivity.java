package com.yujin.demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yujin.demo.R;
import com.yujin.widget.autoviewpager.AutoSlideViewpagerAndPoint;

import java.util.ArrayList;

public class AutoSlideViewPagerActivity extends AppCompatActivity {

    private LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_silde_view_pager);
        l=(LinearLayout) findViewById(R.id.sdss);
        ArrayList<ImageView> lists=getImages();
        final AutoSlideViewpagerAndPoint vp=new AutoSlideViewpagerAndPoint(AutoSlideViewPagerActivity.this,lists);
        vp.startRoll(true);
        vp.setOnPagerClick(new AutoSlideViewpagerAndPoint.onPagerClick() {
            @Override
            public void pagerDoSomething(View imageView, int positon) {
                Toast.makeText(AutoSlideViewPagerActivity.this, ""+positon, Toast.LENGTH_SHORT).show();
            }
        });
        vp.setTIME(3000);
        vp.setOnPagerScrolled(new AutoSlideViewpagerAndPoint.onPagerScrolled() {

            @Override
            public void pagerScrolled(int arg0, float arg1, int arg2) {
//				Toast.makeText(MainActivity.this, ""+arg0, Toast.LENGTH_SHORT).show();
            }
        });
        vp.setmGravityType(AutoSlideViewpagerAndPoint.GRAVITY_LINE_CENTER);
        //vp.setAnimationType(Zhang_ViewPagerAndPoint.ANIMATION_DepthPageTransformer);
        //所有的操作都应该在setViewPagerAndPoint之前完成
        FrameLayout fl=vp.setViewPagerAndPoint();
        l.addView(fl);
    }
    private ArrayList<ImageView> getImages() {
        ArrayList<ImageView> ivs=new ArrayList<ImageView>();
        ImageView iv1=new ImageView(AutoSlideViewPagerActivity.this);
        iv1.setBackgroundResource(R.mipmap.bg);
        ivs.add(iv1);
        ImageView iv2=new ImageView(AutoSlideViewPagerActivity.this);
        iv2.setBackgroundResource(R.mipmap.splash);
        ivs.add(iv2);
        ImageView iv3=new ImageView(AutoSlideViewPagerActivity.this);
        iv3.setBackgroundResource(R.mipmap.bg);
        ivs.add(iv3);
        ImageView iv4=new ImageView(AutoSlideViewPagerActivity.this);
        iv4.setBackgroundResource(R.mipmap.splash);
        ivs.add(iv4);
        return ivs;
    }
    private <T extends View> T $(int id){
        return (T)super.findViewById(id);
    }
}
