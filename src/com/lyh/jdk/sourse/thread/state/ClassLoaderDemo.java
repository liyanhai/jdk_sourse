package com.lyh.jdk.sourse.thread.state;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyanhai
 * @date 2020/8/4 1:08 下午
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

        try {
            Class<?> ccc = Class.forName("com.lyh.jdk.sourse.collection.VolatileDemo");
            System.out.println(ccc.getClassLoader());
            System.out.println(ccc.getClassLoader().getParent());
            System.out.println(ccc.getClassLoader().getParent().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
