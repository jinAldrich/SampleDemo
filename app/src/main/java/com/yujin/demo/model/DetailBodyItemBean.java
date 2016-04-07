package com.yujin.demo.model;

import java.io.Serializable;

/**
 * Created by yujin on 16/4/6.
 */
public class DetailBodyItemBean implements Serializable {
    /**
     * 时光轴需要的数据
     */
    public String month;
    public String day;

    //每一项Item需要的数据
    /**
     * 最左边的图片
     */
    public String leftImage;
    /**
     * 名称
     */
    public String title;
    /**
     * 简介
     */
    public String profile;
    /**
     * 右上角的图片
     */
    public String rightTopImage;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(String leftImage) {
        this.leftImage = leftImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRightTopImage() {
        return rightTopImage;
    }

    public void setRightTopImage(String rightTopImage) {
        this.rightTopImage = rightTopImage;
    }

    @Override
    public String toString() {
        return "[" + month + "," + day + ","+ title + ","+ profile + ","+ leftImage + ","+ rightTopImage +"]";
    }
}
