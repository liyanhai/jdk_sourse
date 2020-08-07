package com.lyh.jdk.sourse.lock;

import java.util.concurrent.TimeUnit;

public class TestLock {
 
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new RunIt());
		Thread t2 = new Thread(new RunIt());
		
		t1.start();
		t2.start();

		TimeUnit.SECONDS.sleep(1);

		t2.interrupt();
		
	}
}
