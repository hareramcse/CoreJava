package com.hs.durga;

class Sample {
	Sample(String s) {
		System.out.println("test class constructor is called with arg "+s);
	}
}

interface Substract {
	public Sample get(String s);
}

public class MyThirdConstructorRefrence {

	public static void main(String[] args) {
		Substract substract = Sample::new;
		Sample test = substract.get("Hareram");
	}
}
