package com.yujin.demo.bean;

import java.util.Comparator;

/**
 * @author: yujin on 16/4/29.
 */
public class Student implements Comparator<Student>{

    /**
     * 学生Id
     */
    private long id = 10001;
    /**
     * 学生姓名
     */
    private String name = "张三";
    /**
     * 学生年龄
     */
    private int age = 24;
    /**
     * 学生体重
     */
    private int weight = 78;
    /**
     * 学生身高
     */
    private int height = 180;
    /**
     * 学生照片
     */
    private String photo = "default photo";
    /**
     * 学生简介
     */
    private String profile = "张三是一名程序员";

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "[" +"id: " + id + " name: " + name
                + " age: " + age + " weight: " + weight
                + " height: " + height + " photo: " + photo
                + " profile: " + profile + "]";

    }
}
