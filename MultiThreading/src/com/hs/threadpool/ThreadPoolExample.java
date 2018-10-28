package com.hs.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	
	public Processor(int id){
		this.id=id;
	}
	
	public void run(){
		System.out.println("started. " +id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("completed. "+id);
	}
}
public class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++){
			executorService.submit(new Processor(i));
		} 
		executorService.shutdown();
		System.out.println("All task submitted..");
		//executorService.submit(new Processor(6)); if you add the task after shutdown we get java.util.concurrent.RejectedExecutionException
		//System.out.println("submitted the task after shutdown call");
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All task completed");
	}
}
