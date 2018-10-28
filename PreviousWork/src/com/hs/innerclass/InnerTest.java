package com.hs.innerclass;

import java.util.ConcurrentModificationException;

public class InnerTest {
	public void run(){
		Outer o=new Outer();
		int x=o.value;
		System.out.println(x);
	}
	
	private static class Outer{
		private static int value=5;
	}
	
	public static void main(String[] args) {
		/*InnerTest test=new InnerTest();
		test.run();*/
		throw new ConcurrentModificationException();
	}
}
