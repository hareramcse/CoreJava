package com.hs.basic;

import java.util.Stack;

public class RandomQuestion {
	public static void main(String[] args) {
		/*boolean a = false;
		if(a=true){
		System.out.println("a is true");
		}else{
		System.out.println("a is false");
		}
		}*/
		
	//	byte a = 127;
	//	byte b = 127;
	//	System.out.println(a == b);// returns true
		
	//	byte a = 128;
	//	byte b = 128; //need to cast to byte because it is out of range of byte
	//	System.out.println(a == b);
		
		/*Integer i = null;
		method(i); // null pointer here
		
*/	
	
	/*public static void method(int k){
		System.out.println(k);
	}*/
		
		/*Integer i1 = 27;
		Integer i2 = new Integer(27);
		Integer i3 = new Integer(27);
		Integer i4 = Integer.valueOf(27);
		Integer i5 = 27;
		System.out.println(i1==i2);// false
		System.out.println(i1==i3);// false
		System.out.println(i1==i4);// true
		System.out.println(i3==i2);// false
		System.out.println(i4==i2);// false
		System.out.println("........");//
		System.out.println(i1==i5);//true
*/		
		
		RandomQuestion rd = new RandomQuestion();
		rd.push(36);
		System.out.println(rd.pop());
	}
	Stack<Integer> stack = new Stack<Integer>();
	public void push(Integer i){
		stack.push(i);
	}
	public Integer pop(){
		return stack.pop();
	}
}