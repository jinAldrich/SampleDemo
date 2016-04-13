package com.yujin.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yujin.demo.BaseActivity;
import com.yujin.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;
    @Bind(R.id.button6)
    Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intentDetail = new Intent();
                intentDetail.setClass(this, DarenDetail.class);
                startActivity(intentDetail);
                break;
            case R.id.button2:
                Intent intentRecycle = new Intent();
                intentRecycle.setClass(this, xrecyclerview.MainActivity.class);
                startActivity(intentRecycle);
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                Intent intent5 = new Intent();
                intent5.setClass(this, com.yujin.demo.zoom.activity.MainActivity.class);
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6 = new Intent();
                intent6.setClass(this, com.yujin.demo.activity.AutoSlideViewPagerActivity.class);
                startActivity(intent6);
                break;
        }
    }
}
