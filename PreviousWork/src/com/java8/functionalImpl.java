package com.java8;

@FunctionalInterface
interface FunctionalInterfaceJava {
	public void test();
	
	// we can have only one abstract method in functionalInterface
	//public void run();
	
	// we can have as many as static concrete method
	public static void log(){
		
	}
}

public class functionalImpl {
	public static void main(String[] args) {
		//here it will give exception as above one is not a functional interface
		// it 
		FunctionalInterfaceJava r=()->System.out.println("print");
	}
}
