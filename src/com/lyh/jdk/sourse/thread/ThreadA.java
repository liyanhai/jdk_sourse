package com.lyh.jdk.sourse.thread;

/**
 * @author liyanhai
 * @date 2020/7/21 2:46 下午
 */
public class ThreadA extends Thread{

    private String name;
    private final Object lock;
    public ThreadA(String name,Object lock){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("线程" + currentThread().getName() + " " + currentThread().getState());
        synchronized (lock){
            System.out.println("线程" + this.name + "正在处理");
            process();
            System.out.println("线程" + this.name + "处理完毕");
        }
    }

    private void process(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
