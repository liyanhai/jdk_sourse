package com.lyh.jdk.sourse.thread.state;

import java.util.Objects;

/**
 * @author liyanhai
 * @date 2020/7/21 2:48 下午
 */
public class ThreadMain {

    public static void main(String[] args) throws Exception{
        threadStateDemo();
    }


    private static void threadStateDemo() throws Exception{

        /**
         * 1、线程AAAA和BBBB未start 之前，两个线程同时处于 NEW 状态
         * 2、启动线程但是未进入同步代码块儿时，线程AAAA处于 RUNNABLE 状态，线程BBBB也处于 RUNNABLE 状态
         * 3、线程AAAA获取到了锁，由于run方法内部执行了 Thread.sleep(5000); 所以线程AAAA便一直处在TIMED_WAITING状态
         *      但是线程BBBB处于BLOCKED（没有竞争到锁,5秒内一直BLOCKED，因为线程AAAA sleep并不释放锁）状态
         * 4、5秒钟后，线程AAAA执行完毕并释放锁，则处于TERMINATED；此时线程BBBB竞争到锁，进入Thread.sleep(5000)，然后5秒钟内处于TIMED_WAITING状态
         * 5、线程BBBB执行完毕后，两个线程都是 TERMINATED 状态，退出while循环
         * @throws Exception
         */
        Object lock = new Object();
        Thread thread = new ThreadA("AAAA",lock);
        Thread thread1 = new ThreadA("BBBB",lock);
        System.out.println("线程:" + thread.getName() + " " + thread.getState());
        System.out.println("线程:" + thread1.getName() + " " + thread1.getState());

        System.out.println("==========start before========");
        thread.start();
        thread1.start();
        while (!(Objects.equals(Thread.State.TERMINATED,thread.getState()) && Objects.equals(Thread.State.TERMINATED,thread1.getState()))){
            System.out.println("线程:" + thread.getName() + " " + thread.getState());
            System.out.println("线程:" + thread1.getName() + " " + thread1.getState());
            Thread.sleep(1000);
        }

        System.out.println("AAAAAAAAAAAAAAABBBBBBBBBBBBBB");

        /**
         * 1、线程A内部执行wait方法后（同时释放锁），进入 WAITING 状态
         * 2、线程B拿到锁之后，内部执行 Thread.sleep(3000) 进入 TIMED_WAITING，但是并没有释放锁，
         *      而由于线程A执行了wait操作，所以在没有拿到锁之前一直处于WAITING
         * 3、3秒钟过后，线程B执行完毕，释放锁，线程状态变成 TERMINATED，线程A获取到锁之后，并由 WAITING -> TIMED_WAITING -> TERMINATED
         *
         */
        Thread threadA = new ThreadB("A",lock);
        Thread.sleep(1000);
        Thread threadB = new ThreadB("B",lock);
        threadA.start();
        threadB.start();

        while (!(Objects.equals(Thread.State.TERMINATED,threadA.getState()) && Objects.equals(Thread.State.TERMINATED,threadB.getState()))){
            System.out.println("线程&&&:" + threadA.getName() + " " + threadA.getState());
            System.out.println("线程&&&:" + threadB.getName() + " " + threadB.getState());
            Thread.sleep(300);
        }
    }

}
