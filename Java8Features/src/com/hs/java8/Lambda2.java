package com.hs.java8;

@FunctionalInterface
interface Lambda3 {
	public void m1();
}

public interface Lambda2 extends Lambda3 {
	public void m2();
}
