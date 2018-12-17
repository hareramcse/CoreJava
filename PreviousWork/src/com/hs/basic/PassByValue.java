package com.hs.basic;

public class PassByValue {
	int i;

	PassByValue(int i) {
		this.i = i;
	}

	public void test(int i) {
		this.i = i + 10;
	}

	public static void main(String[] args) {
		int i = 20;
		PassByValue value = new PassByValue(i);
		value.test(i);
		System.out.println(i);
	}
}
