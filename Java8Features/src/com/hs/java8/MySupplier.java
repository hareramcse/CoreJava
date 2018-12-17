package com.hs.java8;

import java.util.Date;
import java.util.function.Supplier;

public class MySupplier {
	public static void main(String[] args) {
		Supplier<Date> supplier = () -> new Date();
		System.out.println(supplier.get());
		Supplier<String> random=()->{
			String otp="";
			for (int i = 0; i < 6; i++) {
				otp= otp+(int)(Math.random()*10);				
			}
			return otp;
		};
		
		System.out.println(random.get());
	}
}
