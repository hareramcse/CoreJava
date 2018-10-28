package com.hs.rejectionhandler;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* Asynchrounous Task Should extend TimerTask */
class JobTask extends TimerTask {
	private String jobId = "";

	public JobTask(String jobId) {
		this.jobId = jobId;
	}

	public String getJobId() {
		return jobId;
	}

	@Override
	public void run() {

		System.out.println(jobId + " Running through Thread:" + Thread.currentThread().getName());
		/* Make the Task to sleep for 5 seconds,so that the task will be busy */
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return jobId;
	}
}

/* RejectionHandler to handle any rejected Task */
class JobRejectionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
		JobTask jobTask = (JobTask) runnable;
		System.out.println(jobTask.getJobId() + " Running through RejectionHandler,Since "
				+ "there are no ideal threads in ThreadPool");
	}

}

public class RejectedExecutionExceptionExample {

	private ThreadPoolExecutor threadPoolExecutor = null;

	private void createThreadPool() {
		int poolSize = 2;
		int maxPoolSize = 5;
		int queueSize = 3;
		long aliveTive = 1000;
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(queueSize);
		/* threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, aliveTive, TimeUnit.MILLISECONDS, queue,
				new JobRejectionHandler()); */
		/*threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, aliveTive, TimeUnit.MILLISECONDS, queue,
				new ThreadPoolExecutor.AbortPolicy()); */
		
		/*threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, aliveTive, TimeUnit.MILLISECONDS, queue,
				new ThreadPoolExecutor.CallerRunsPolicy()); */
		
		/*threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, aliveTive, TimeUnit.MILLISECONDS, queue,
				new ThreadPoolExecutor.DiscardPolicy()); */
		
		threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, aliveTive, TimeUnit.MILLISECONDS, queue,
				new ThreadPoolExecutor.DiscardOldestPolicy()); 
	}

	private void submitTask() {
		/* Submit 10 AsunchronousTask to ThreadPool */
		for (int i = 1; i <= 10; i++) {
			threadPoolExecutor.execute(new JobTask("Job" + i));
		}
	}

	public static void main(String[] args) {
		RejectedExecutionExceptionExample rejectedExecutionExceptionExample = new RejectedExecutionExceptionExample();
		rejectedExecutionExceptionExample.createThreadPool();// To create the ThreadPool
		rejectedExecutionExceptionExample.submitTask();// To submit the Task
	}
}