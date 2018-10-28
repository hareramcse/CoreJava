package com.hs.general;

class StateCheckThread extends Thread {
	public void run() {
		System.out.println("begin");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("sleep interupted");
		}
		System.out.println("end");
	}
}



public class StateCheck {
	public static void main(String[] args) {
		StateCheckThread b1 = new StateCheckThread();
		b1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		b1.interrupt();
	}
}