package com.lyh.jdk.sourse.concurrent;

/**
 * @author liyanhai
 * @date 2020/8/4 7:42 下午
 */
public class User {

    private String name;
    private int age;

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
