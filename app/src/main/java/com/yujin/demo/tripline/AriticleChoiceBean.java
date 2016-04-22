package com.yujin.demo.tripline;

import java.io.Serializable;

/**
 * Created by yujin on 4/14/16.
 */
public class AriticleChoiceBean implements Serializable {

    /**
     * 文章图片路径
     */
    public String imagePath;
    /**
     * 文章标题
     */
    public String title;
    /**
     * 文章内容
     */
    public String content;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + "imagePath: " + imagePath + " title: " + title + " content: " + content +"]";
    }
}
