package com.yujin.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yujin.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 演示RxJava的使用
 * <p>
 * RxJava正在Android开发者中变的越来越流行。唯一的问题就是上手不容易，尤其是大部分人之前都是使用命令式编程语言。
 * 但是一旦你弄明白了，你就会发现RxJava真是太棒了。
 * <p>
 * RxJava最核心的两个东西是Observables（被观察者，事件源）和Subscribers（观察者）。
 * Observables发出一系列事件，Subscribers处理这些事件。这里的事件可以是任何你感兴趣的东西（触摸事件，web接口调用返回的数据。。。）
 */
public class RxJavaActivity extends AppCompatActivity {

    @Bind(R.id.bt_1)
    Button bt1;
    @Bind(R.id.bt_2)
    Button bt2;
    @Bind(R.id.bt_3)
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                break;
            case R.id.bt_2:
                break;
            case R.id.bt_3:
                break;
        }
    }
}
