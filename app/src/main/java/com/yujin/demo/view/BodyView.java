package com.yujin.demo.view;

import com.yujin.demo.model.DetailBodyItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujin on 16/4/6.
 */
public interface BodyView extends DetailView {

    void showLoadFailedMsg();
    void showProgress();
    void loadBodyData(ArrayList<DetailBodyItemBean> datas);
}
