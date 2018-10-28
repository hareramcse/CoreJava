package com.hs.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Runner {
	BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(10);
	
	public void producer(){
		for(int i=0;i<=5;i++){
			try {
				blockingQueue.put(i);
				System.out.println(Thread.currentThread().getName()+" produces the value " +i);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void consumer(){
		for(int i=0;i<=5;i++){
			try {
				int j=blockingQueue.take();
				System.out.println(Thread.currentThread().getName()+" consumer consumes the value "+j);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PCByBlockingQueue {
	public static void main(String[] args) {
		final Runner runner=new Runner();
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				runner.producer();
			}
		});
		t1.setName("Thread 1");

		Thread t2=new Thread(new Runnable() {
			public void run() {
				runner.producer();
			}
		});
		t1.setName("Thread 2");
		
		Thread t3=new Thread(new Runnable() {
			public void run() {
				runner.producer();
			}
		});
		t1.setName("Thread 3");
		
		Thread t4=new Thread(new Runnable() {
			public void run() {
				runner.consumer();
			}
		});
		t1.setName("Thread 4");
		
		Thread t5=new Thread(new Runnable() {
			public void run() {
				runner.consumer();
			}
		});
		t1.setName("Thread 5");
		
		Thread t6=new Thread(new Runnable() {
			public void run() {
				runner.consumer();
			}
		});
		t1.setName("Thread 6");
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();		

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}