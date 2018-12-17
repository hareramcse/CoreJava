package com.hs.basic;

public class NullCheck {
	/*public void run(String s){
		System.out.println(s);
	}
	public void run(Integer i){
		System.out.println("hello");
		System.out.println(i);
	}
	public static void main(String[] args) {
		NullCheck n = new  NullCheck();
		n.run(null); // ambiguity
	}*/
	
	public void run(Object s){
		System.out.println(s);
	}
	public void run(Integer i){
		System.out.println("hello");
		System.out.println(i);
	}
	public static void main(String[] args) {
		NullCheck n = new  NullCheck();
		n.run(null);
	}

}
