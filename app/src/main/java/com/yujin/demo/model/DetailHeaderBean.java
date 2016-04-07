package com.yujin.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yujin on 16/4/6.
 */
public class DetailHeaderBean implements Serializable {
    /**
     * toolbar需要的数据
     */
    private String toolbarImage;
    private String toolbarTitle;

    //header需要的数据
    /**
     * header背景图片
     */
    private String background;
    /**
     * 圆形头像
     */
    private String headerImage;
    /**
     * 网名
     */
    private String nickName;
    /**
     * 性格特征
     */
    private List<String> characters;
    /**
     * 座右铭
     */
    private String motto;

    @Override
    public String toString() {
        return "[" + toolbarImage + "," + toolbarTitle + ","+ background + ","
                + headerImage + ","+ nickName + ","+ motto +"]";
    }
}
