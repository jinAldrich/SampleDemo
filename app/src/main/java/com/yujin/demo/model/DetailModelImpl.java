package com.yujin.demo.model;

import android.os.Handler;

import com.yujin.demo.presenter.DetailPresenterImpl;

import java.util.TimerTask;

/**
 * Created by yujin on 16/4/6.
 */
public class DetailModelImpl implements DetailModel{
    public static final String TAG = DetailModelImpl.class.getSimpleName();
    private DetailPresenterImpl mDetailPresenterImpl;

    @Override
    public boolean loadHeader(String url, onLoadHeaderListener listener) {
        return false;
    }

    @Override
    public boolean loadBody(String url, final onLoadBodyListener listener) {
        //先用本地数据模拟网络请求
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);//模拟网络延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(listener != null) {
                    DetailBodyItemBean bean = new DetailBodyItemBean();
                    bean.title = "模拟网络-丹麦大教堂";
                    bean.profile = "罗斯基勒大教堂是丹麦最杰出的建筑精品之一,世界遗产委员会将其列入世界遗产名单";
                    bean.leftImage = "http://123.56.148.217:2020/bdfile/file/getFile.do?filename=/20160203/e35ed5a48fc472a80fedfea892432cc2.jpg";
                    bean.month = "3";
                    bean.day = "18";
                    listener.onBodySuccess(bean);
                }
            }
        }.start();

        return false;
    }

    public interface onLoadHeaderListener {
        void onHeaderSuccess(DetailHeaderBean headerBean);
        void onHeaderFailure(String failMsg, Exception e);
    }

    public interface onLoadBodyListener {
        void onBodySuccess(DetailBodyItemBean bodyItemBean);
        void onBodyFailure(String failMsg, Exception e);
    }
}
