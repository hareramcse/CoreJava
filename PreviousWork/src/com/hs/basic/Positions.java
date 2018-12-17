package com.hs.basic;

public enum Positions {
	FIRST, SECOND, THIRD;
	public char STAGES() {
		char level = '\u0000';
		switch (this) {
		case FIRST:
			level = 'C';
			break;
		case SECOND:
			level = 'Y';
			break;
		case THIRD:
			level = 'O';
			break;
		}

		return level;
	}

	public static void main(String[] args) {
		System.out.println(FIRST.STAGES());
	}
}
