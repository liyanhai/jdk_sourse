package com.lyh.jdk.sourse.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liyanhai
 * @date 2020/8/4 7:41 下午
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

//        AtomicReference<User> atomicReference = new AtomicReference<>();
        User lyh = new User("liyanhai",25);
        User ls = new User("lishuang",24);
//        atomicReference.set(lyh);
//
//        boolean b = atomicReference.compareAndSet(lyh, ls);
//        System.out.println(b);
//        System.out.println(atomicReference.get());
        AtomicStampedReference<User> atomicStampedReference = new AtomicStampedReference<>(lyh,1);

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t1第一次版本号:" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(lyh,ls,stamp,stamp + 1);
            System.out.println("t1第二次版本号:" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(ls,lyh,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            System.out.println("t1第三次版本号:" + atomicStampedReference.getStamp());

        },"t1").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t2第一次版本号:" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicStampedReference.compareAndSet(lyh, ls, stamp, stamp + 1);
            System.out.println("t2第二次版本号:" + atomicStampedReference.getStamp() + ",设置是否成功:" + b);

        },"t2").start();

    }

}
