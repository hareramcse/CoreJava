package com.hs.usecase;

public class PolindromWithRecursion {

	private String reverseString(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() <= 1) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);

	}

	public static void main(String[] args) {
		String str = "aba";
		PolindromWithRecursion pwr = new PolindromWithRecursion();
		String reversedString = pwr.reverseString(str);
		if (reversedString.equals(str)) {
			System.out.println(str + " is a polindrom");
		}
	}
}
