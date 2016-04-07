package com.yujin.demo.model;

/**
 * Created by yujin on 16/4/6.
 */
public interface DetailModel {

    boolean loadHeader(String url, DetailModelImpl.onLoadHeaderListener listener);
    boolean loadBody(String url, DetailModelImpl.onLoadBodyListener listener);

}
