package com.bailun.utils;

/**
 * create by chl on 2019/12/27
 * description
 */
public class TestBean {

    private int age;
    private String name;

    public TestBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
