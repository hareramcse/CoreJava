package com.hs.core;

class Reflection {
	Reflection() {
		System.out.println("Hi");
	}
}

public class ReflectionCheck {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class cls = Class.forName("com.hs.core.Reflection");
		Reflection rf = (Reflection) cls.newInstance();
	}
}
