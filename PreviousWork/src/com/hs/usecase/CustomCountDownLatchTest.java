package com.hs.usecase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomCountDownLatch {

	private int count;

	public CustomCountDownLatch(int count) {
		this.count = count;
	}

	public synchronized void await() throws InterruptedException {
		if (count > 0)
			this.wait();
	}

	public synchronized void countDown() {
		count--;
		if (count == 0)
			this.notifyAll();
	}

}

class Processor implements Runnable {

	CustomCountDownLatch countDownLatchCustom;

	Processor(CustomCountDownLatch countDownLatchCustom) {
		this.countDownLatchCustom = countDownLatchCustom;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started...");
		try {
			System.out.println(Thread.currentThread().getName() + " waiting...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatchCustom.countDown();
		System.out.println(Thread.currentThread().getName() + " completed...");
	}

}

public class CustomCountDownLatchTest {

	public static void main(String[] args) {
		CustomCountDownLatch countDownLatchCustom = new CustomCountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Processor(countDownLatchCustom));
		}
		try {
			System.out.println("waiting to count down latch to 0");
			countDownLatchCustom.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		System.out.println("completed.....");
	}
}