package com.hs.exception;

class MyRunnable implements Runnable {

	String str;

	/*
	 * method will terminate due to an uncaught unchecked(runtime) exception.
	 */
	public void run() {
		/*
		 * String wasn't initialized, so performing any operation on it will
		 * throw NullPointerException and it will caught by default handler
		 * defined in main method.
		 */
		str.equals("abc");
	}
}

public class MyThreadException {
	public static void main(String[] args) {

		Thread thread1 = new Thread(new MyRunnable(), "thread-1");

		/*
		 * setDefaultUncaughtExceptionHandler method sets the default handler
		 * which is called when a thread terminates due to an uncaught
		 * unchecked(runtime) exception.
		 */
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread thread, Throwable throwable) {
				System.out.println(thread.getName() + " has thrown "
						+ throwable);
			}
		});

		thread1.start();
	}
}
