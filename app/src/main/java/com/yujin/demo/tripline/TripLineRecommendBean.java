package com.yujin.demo.tripline;

import java.io.Serializable;

/**
 * Created by yujin on 4/14/16.
 */
public class TripLineRecommendBean implements Serializable {

    /**
     * 左边图片展示
     */
    public String icon;
    /**
     * 出发地
     */
    public String fromLocation;
    /**
     * 行程三天
     */
    public String route;
    /**
     * 旅行区域,如[国内], [国外]
     */
    public String tripArea;
    /**
     * 旅行类型,如[海景岛恋]
     */
    public String tripType;
    /**
     * 旅行日期, 如[双飞5日]
     */
    public String tripDate;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTripArea() {
        return tripArea;
    }

    public void setTripArea(String tripArea) {
        this.tripArea = tripArea;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    @Override
    public String toString() {
        return "[" + "icon: " + icon + " fromLocation: " + fromLocation + " route: "
                + route + " tripArea: " + tripArea+ " tripType: " + tripType+ " tripDate: " + tripDate+"]";
    }
}
