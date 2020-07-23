package com.lyh.jdk.sourse.thread.state;

import java.time.LocalDateTime;

/**
 * @author liyanhai
 * @date 2020/7/22 7:08 下午
 */
public class ThreadTest {

    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                LocalDateTime endTime = LocalDateTime.now().plusSeconds(2);
                while (LocalDateTime.now().isBefore(endTime)){

                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("异常。。。。。");
                    //e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());

        System.out.println("主线成结束");

    }

}
