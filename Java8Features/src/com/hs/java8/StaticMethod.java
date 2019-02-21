package com.hs.java8;

interface Static{
	public static void m1() {
		System.out.println("static m1");
	}
}
public class StaticMethod implements Static{
	public static void m1() {
		System.out.println("static m2");
	}
	
	public static void main(String[] args) {
		Static.m1();
	//	m1();
	//	StaticMethod staticMethod=new StaticMethod();
	//	staticMethod.m1();
	}
}

