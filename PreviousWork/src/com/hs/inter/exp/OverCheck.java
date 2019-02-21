package com.hs.inter.exp;

class Hello {
	String type = "f";

	Hello() {
		System.out.println("Hello");
	}
}

public class OverCheck extends Hello {
	public OverCheck() {
		System.out.println("Overcheck");
	}
	
	private void go() {
		type="c";
		System.out.println(super.type+this.type);
	}
	
	
	public static void main(String[] args) {
		new OverCheck().go();
	}
}
