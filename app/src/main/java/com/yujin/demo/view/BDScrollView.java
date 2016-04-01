package com.yujin.demo.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by yujin on 16/3/31.
 */
public class BDScrollView extends ScrollView {
    private OnScrollListener onScrollListener;
    private int lastScrollY;

    public BDScrollView(Context context) {
        this(context, null);
    }

    public BDScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BDScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置滚动接口
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            int scrollY = BDScrollView.this.getScrollY();

            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息
            if(lastScrollY != scrollY){
                lastScrollY = scrollY;
                handler.sendMessageDelayed(handler.obtainMessage(), 5);
            }
            if(onScrollListener != null){
                onScrollListener.onScroll(scrollY);
            }

        };

    };

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(onScrollListener != null){
            onScrollListener.onScroll(lastScrollY = this.getScrollY());
        }
        switch(ev.getAction()){
            case MotionEvent.ACTION_UP:
                handler.sendMessageDelayed(handler.obtainMessage(), 5);
                break;
        }
        return super.onTouchEvent(ev);
    }


    /**
     *
     * 滚动的回调接口
     *
     */
    public interface OnScrollListener{
        public void onScroll(int scrollY);
    }
}
