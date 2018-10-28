package com.hs.string;

public class StringPermutation {

	private static void permutation(String perfix, String value) {
		int length = value.length();
		if (length == 0) {
			System.out.println(perfix);
		} else {
			for (int i = 0; i < length; i++) {
				permutation(perfix + value.charAt(i), value.substring(0, i)
						+ value.substring(i + 1, length));
			}
		}
	}

	public static void main(String[] args) {
		StringPermutation.permutation("", "abc");
	}
}
