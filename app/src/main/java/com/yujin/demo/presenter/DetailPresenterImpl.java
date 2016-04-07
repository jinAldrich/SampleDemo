package com.yujin.demo.presenter;

import android.content.Context;
import android.util.Log;

import com.yujin.demo.model.DetailBodyItemBean;
import com.yujin.demo.model.DetailHeaderBean;
import com.yujin.demo.model.DetailModel;
import com.yujin.demo.model.DetailModelImpl;
import com.yujin.demo.view.BodyView;
import com.yujin.demo.view.DetailView;
import com.yujin.demo.view.HeaderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujin on 16/4/6.
 */
public class DetailPresenterImpl implements DetailPresenter, DetailModelImpl.onLoadBodyListener, DetailModelImpl.onLoadHeaderListener {
    public static final String TAG = DetailPresenterImpl.class.getSimpleName();

    private Context mContext;
    private HeaderView mHeaderView;
    private BodyView mBodyView;
    private DetailModel mDetailModel;

    public DetailPresenterImpl(Context context, DetailView view) {
        mContext = context;
        if (view instanceof HeaderView) {
            mHeaderView = (HeaderView)view;
        }
        if (view instanceof BodyView) {
            mBodyView = (BodyView)view;
        }
        mDetailModel = new DetailModelImpl();
    }

    @Override
    public void loadHeader(int type, int pageIndex) {
        mDetailModel.loadHeader(null, this);
    }

    @Override
    public void loadBody(int type, int pageIndex) {
        mDetailModel.loadBody(null, this);
    }

    @Override
    public void onHeaderFailure(String failMsg, Exception e) {
        Log.i(TAG, "Header data deal failure, the reason is " + failMsg);

    }

    @Override
    public void onHeaderSuccess(DetailHeaderBean headerBean) {

    }

    @Override
    public void onBodySuccess(DetailBodyItemBean bodyItemBean) {
        ArrayList<DetailBodyItemBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(bodyItemBean);
        }
        mBodyView.loadData(list);
    }

    @Override
    public void onBodyFailure(String failMsg, Exception e) {
        Log.i(TAG, "Body data deal failure, the reason is " + failMsg);
        mBodyView.showLoadFailedMsg();
    }

    public interface OnLoadHeaderListener {
        void onSuccess(DetailHeaderBean bean);
        void onFailure(String failMsg, Exception e);
    }
    public interface OnLoadBodyListener {
        void onSuccess(DetailBodyItemBean bean);
        void onFailure(String failMsg, Exception e);
    }
}
