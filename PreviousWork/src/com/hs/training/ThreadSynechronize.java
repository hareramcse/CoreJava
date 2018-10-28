package com.hs.training;

public class ThreadSynechronize extends Thread {
	synchronized void m1() {
		System.out.println("m1");
	}

	synchronized void m2() {
		System.out.println("m2");
	}

	synchronized static void m3() {
		System.out.println("m3");
	}

	synchronized static void m4() {
		System.out.println("m4");
	}

	synchronized void m5() {
		m1();
		m2();
	}

	synchronized void m6() {
		m1();
		m3();
	}

	public static void main(String[] args) {
		ThreadSynechronize t = new ThreadSynechronize();
		t.m5();
		try {
			Thread.sleep(6000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.m6();
	}
}
