package com.hs.java8;

interface I2 {
	public void sum(int a, int b);
}

public class Demo2 {
	public static void main(String[] args) {
		I2 i2 = (a, b) -> System.out.println("Sum is " + (a + b));
		i2.sum(10, 20);
	}
}
