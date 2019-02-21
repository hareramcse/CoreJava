package com.hs.inter.exp;

public class LoopCheck {
	public static void main(String[] args) {
		String[] str = { "one", "two" };

		for (int i = 0; i < 3; i++) {
			for (String s : str) {
				System.out.println(i + " " + s);
				if (i == 1) {
					break;
				}
			}
		}
	}
}
