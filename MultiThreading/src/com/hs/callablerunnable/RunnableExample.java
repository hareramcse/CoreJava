package com.hs.callablerunnable;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExample {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		/*
		 * Future<Integer> future=executorService.submit(new Callable<Integer>()
		 * {
		 * 
		 * public Integer call() throws Exception { Random random=new Random();
		 * int duration=random.nextInt(4000); if(duration>2000){ throw new
		 * IOException(); } System.out.println("starting...");
		 * Thread.sleep(duration); System.out.println("Finished"); return
		 * duration; } });
		 */

		Future<?> future = executorService.submit(new Callable<Void>() { // if
																			// you
																			// want
																			// to
																			// return
																			// nothing
					public Void call() throws Exception {
						Random random = new Random();
						int duration = random.nextInt(4000);
						if (duration > 2000) {
							throw new IOException();
						}
						System.out.println("starting...");
						Thread.sleep(duration);
						System.out.println("Finished");
						return null;
					}
				});
		executorService.shutdown();

		try {
			System.out.println("Result is " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e);
		}
	}
}
