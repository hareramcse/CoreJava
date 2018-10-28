package com.hs.core;

public class StaticOrder {
	static {
		x = 10;
	}
	static int x = 20;

	public static void main(String[] args) {
		System.out.println(x);
	}
}
