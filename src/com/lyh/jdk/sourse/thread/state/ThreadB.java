package com.lyh.jdk.sourse.thread.state;

/**
 * @author liyanhai
 * @date 2020/7/21 6:36 下午
 */
public class ThreadB extends Thread {

    private String name;
    private final Object lock;
    public ThreadB(String name,Object lock){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("线程---" + currentThread().getName() + " " + currentThread().getState());
            if("A".equals(this.name)){
                try {
                    System.out.println("线程A wait");
                    lock.wait();
                    process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("线程B process");
                process();
                lock.notifyAll();
            }
        }
    }

    private void process(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
