package com.hs.timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Timer task started at:" + new Date());
		completeTask();
		System.out.println("Timer task finished at:" + new Date());
	}

	private void completeTask() {
		try {
			// assume it takes 10 secs to complete the task
			System.out.println("going in sleep state for 10 sec ");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		TimerTask timerTask = new MyTimerTask();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 5 * 1000);
		System.out.println("TimerTask started");
		// cancel after sometime
		try {
			System.out.println("going in sleep state for 7 sec");
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			System.out.println("going in sleep state for 3 sec");
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}