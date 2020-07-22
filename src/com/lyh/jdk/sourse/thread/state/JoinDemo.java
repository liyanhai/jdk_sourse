package com.lyh.jdk.sourse.thread.state;

/**
 * @author liyanhai
 * @date 2020/7/22 6:19 下午
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock){

                    System.out.println("当前线程: " + Thread.currentThread().getName() + "获取到锁");

                    try {
                        lock.wait(5000);
                        System.out.println(Thread.currentThread().getName() + "继续执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("当前线程: " + Thread.currentThread().getName() + "获取到锁");

                    try {
                        Thread.sleep(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "继续执行");
                    lock.notify();
                }
            }
        });

        //join会让主线程等待，直到thread线程执行完毕，底层用的是wait方法
        //而wait和notify只有获取到对象监视器锁才允许调用，不然会抛出 IllegalMonitorStateException
        thread.join();
        System.out.println("主线程执行完毕");
    }

}
