package com.yujin.demo.tripline;

import android.os.Parcel;
import android.os.Parcelable;

import com.yujin.demo.base.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by yujin on 4/14/16.
 */
public class TripLineBean extends BaseBean {

    public TripLineBean(Parcel in) {

    }

    public TripLineBean() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static class TripLineBeanItemBean {
        /**
         * 数据类型(0.广告  1.交通和娱乐  2.百代精选  3.路线推荐)
         */
        private int type;
        /**
         * 类型标题,如百代精选, 路线推荐
         */
        private String title;
        /**
         * 滚动播放的广告数据
         */
        private ArrayList advertiseImage = new ArrayList();
        /**
         * 百代文章精选数据
         */
        private ArrayList<AriticleChoiceBean> ariticleChoiceList = new ArrayList<AriticleChoiceBean>();
        /**
         * 路线推荐数据
         */
        private ArrayList<TripLineRecommendBean> tripLineRecommendList = new ArrayList<TripLineRecommendBean>();

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public ArrayList getAdvertiseImage() {
            return advertiseImage;
        }

        public void setAdvertiseImage(ArrayList advertiseImage) {
            this.advertiseImage = advertiseImage;
        }

        public ArrayList<TripLineRecommendBean> getTripLineRecommendList() {
            return tripLineRecommendList;
        }

        public void setTripLineRecommendList(ArrayList<TripLineRecommendBean> tripLineRecommendList) {
            this.tripLineRecommendList = tripLineRecommendList;
        }

        public ArrayList<AriticleChoiceBean> getAriticleChoiceList() {
            return ariticleChoiceList;
        }

        public void setAriticleChoiceList(ArrayList<AriticleChoiceBean> ariticleChoiceList) {
            this.ariticleChoiceList = ariticleChoiceList;
        }
    }

    /**
     * Parcelable创建对象时所用的类
     */
    public static final Parcelable.Creator<TripLineBean> CREATOR
            = new Parcelable.Creator<TripLineBean>() {
        public TripLineBean createFromParcel(Parcel in) {
            return new TripLineBean(in);
        }

        public TripLineBean[] newArray(int size) {
            return new TripLineBean[size];
        }
    };
}
