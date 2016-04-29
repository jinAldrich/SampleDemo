package com.yujin.demo.bean;

import java.util.Comparator;

/**
 * @author: yujin on 16/4/29.
 */
public class Student implements Comparator<Student>{

    /**
     * 学生Id
     */
    private long id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生年龄
     */
    private int age;
    /**
     * 学生体重
     */
    private int weight;
    /**
     * 学生身高
     */
    private int height;
    /**
     * 学生照片
     */
    private String photo;
    /**
     * 学生简介
     */
    private String profile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public int compare(Student lhs, Student rhs) {
        return 0;
    }
}
