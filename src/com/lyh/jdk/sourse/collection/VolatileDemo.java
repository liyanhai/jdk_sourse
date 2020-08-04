package com.lyh.jdk.sourse.collection;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

	public static void main(String[] args) {

		MyData myData = new MyData();

		new Thread(() -> {

			System.out.println(Thread.currentThread().getName() + "\t come in");

			try {

				TimeUnit.SECONDS.sleep(3);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			myData.add();

			System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);

		}, "AAA").start();

		// 第2个线程就是我们的main线程

		while (myData.number == 0) {

			// main线程就一直在这里等待循环，直到number值不再等于0

		}

		System.out.println(Thread.currentThread().getName() + "\t mission is over");

	}

}

class MyData {

	//int number = 0;

	volatile int number = 0;

	public void add() {

		this.number = 60;

	}

}