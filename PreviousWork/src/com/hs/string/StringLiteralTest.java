package com.hs.string;

public class StringLiteralTest {
	public static void main(String[] args) {
		String s1="abc";
		String s2=new String("abc");
		String s3=s2.intern();
		System.out.println(s1.hashCode());
		System.out.println(s3.hashCode());
	}
}
