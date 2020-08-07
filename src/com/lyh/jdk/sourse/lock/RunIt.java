package com.lyh.jdk.sourse.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunIt implements Runnable {

    private static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            runJob();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Interrrupted from runJob.");
        }
    }

    private void runJob() throws InterruptedException {
		//lock.lockInterruptibly();
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try {
                System.out.println(Thread.currentThread().getName() + " 到此一游....");
                System.out.println(Thread.currentThread().getName() + " running");
                TimeUnit.SECONDS.sleep(4);
                System.out.println(Thread.currentThread().getName() + " finished");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            } finally {
                lock.unlock();
            }
        }else{
            System.out.println("没有获取到锁");
        }

    }
}
 