package com.lyh.jdk.sourse.lock;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyanhai
 * @date 2020/8/7 9:27 上午
 */
public class LockSourceDemo {



    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while (true){
                        if(queue.size() == 5){
                            System.out.println("队列已经满了，停止生产");
                            notFull.await();
                        }
                        queue.add(new Random().nextInt(10));
                        System.out.println(Thread.currentThread().getName() + "队列中的数据:" + queue);
                        notEmpty.signal();
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        },"生产者").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while (true){
                        if(queue.isEmpty()){
                            System.out.println("队列空了,停止消费");
                            notEmpty.await();
                        }
                        System.out.println("消费到到数据为:" + queue.take());
                        notFull.signal();
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        },"消费者").start();



    }

}
