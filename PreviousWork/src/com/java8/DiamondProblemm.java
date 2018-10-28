package com.java8;

interface A{
	public void test();
	
	//we can't create the non static non abstract metod
	/*public void run(){
		
	}
	*/
	public void log();
	
	//if we write the method static then we need to give the body that is mandatory.
	//public static void run();
	
	public static void run(){
		
	}
}

interface B{
	public void log();
}
public class DiamondProblemm implements A,B {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		A.run();
	}

}
