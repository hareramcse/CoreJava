package com.hs.generics;

class T<A> {
	A s2;
}

public class GenericTest3 {
	public static void main(String[] args) {
		T<?> t1 = null;
		t1 = new T<Integer>();
		t1 = new T<Number>();
		t1 = new T<Object>();
		t1 = new T<String>();

		T<? extends Number> t2 = null;
		t2 = new T<Integer>();
		t2 = new T<Number>();
		//t2 = new T<Object>();
		// t2 = new T<String>();
		
		T<? super Number> t3 = null;
		//t3 = new T<Integer>();
		t3 = new T<Number>();
		t3 = new T<Object>();
		//t1 = new T<String>();
	}
}
