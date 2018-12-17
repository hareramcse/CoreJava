package com.hs.basic;

public class GarbageCollection {
	int i = 50;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("From Finalize Method");
		//throw new Exception();
	}

	public static void main(String[] args) {
		// Creating two instances of class GarbageCollection

		GarbageCollection a1 = new GarbageCollection();

		GarbageCollection a2 = new GarbageCollection();

		// Assigning a2 to a1

		a1 = a2;

		// Making finalize() method to execute forcefully

		//Runtime.getRuntime().runFinalization();

		System.gc();
		System.gc();
		System.gc();
		System.out.println(a1);
		System.out.println("done");
	}
}
