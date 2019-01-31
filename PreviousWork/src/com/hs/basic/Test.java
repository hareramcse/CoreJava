package com.hs.basic;

public class Test {
	public static void main(String[] args) {
		/*
		 * int i = 2; int j = 1; if ((i == 20) && (j == (i = i * 2))) {}
		 * System.out.println(i); if ((i == 20) & (j == (i = i * 2))){}
		 * System.out.println(i); int x = i & 2; System.out.println(x); out.println();
		 * 
		 * String str=new String("string"); try { str.wait(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		try {
			System.out.println("hello");
		} catch (Exception e) {
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			System.out.println("finally");
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
