package com.hs.previouswork;

public class ContianerObject {
	public static void main(String[] args) {
		String str=new String("abc");
		try {
			str.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
