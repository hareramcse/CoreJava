package com.hs.previouswork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class Task implements Runnable {
	private int taskId;

	public Task(int id) {
		this.taskId = id;
	}

	public void run() {
		System.out.println("Task ID : " + this.taskId + " performed by "
				+ Thread.currentThread().getName());
	}
}

public class SimpleThreadPool {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			service.submit(new Task(i));
		}
	}
}
