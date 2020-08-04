package com.lyh.jdk.sourse.thread.state;

import java.util.concurrent.TimeUnit;

/**
 * @author liyanhai
 * @date 2020/8/4 11:02 上午
 */
public class VolatileDemo {

    public static void main(String[] args) {

        Data data = new Data();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {

                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            data.add();

            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + data.number);

        }, "AAA").start();


        int number = data.number;

        while (number == 0){
//            number = data.number;
//            System.out.println("main thread get number : " + number);
        }

        System.out.println("end....");

    }

}

class Data{
    int number = 0;

    //volatile int number = 0;

    public void add() {

        this.number = 60;

    }
}
