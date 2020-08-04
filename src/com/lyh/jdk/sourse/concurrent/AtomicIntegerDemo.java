package com.lyh.jdk.sourse.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyanhai
 * @date 2020/8/4 6:40 下午
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        int i = atomicInteger.get();
        System.out.println(i);
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(atomicInteger.get());
    }


}
