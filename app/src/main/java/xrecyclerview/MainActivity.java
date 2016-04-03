package xrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yujin.demo.BaseActivity;
import com.yujin.demo.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recyclerview);
    }
    public void gotoLinearActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, LinearActivity.class);
        startActivity(intent);
    }
    public void gotoGridActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this,GridActivity.class);
        startActivity(intent);
    }
    public void gotoStaggeredGridActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, StaggeredGridActivity.class);
        startActivity(intent);
    }

}
