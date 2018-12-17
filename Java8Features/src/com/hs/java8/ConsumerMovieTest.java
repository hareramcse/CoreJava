package com.hs.java8;

import java.util.function.Consumer;

class ConsumerMovie {
	String name;

	public ConsumerMovie(String name) {
		this.name = name;
	}
}

class ConsumerMovieTest {
	public static void main(String[] args) {
		Consumer<ConsumerMovie> c1 = m -> System.out.println(m.name + " released");
		Consumer<ConsumerMovie> c2 = m -> System.out.println(m.name + " released but got floped");
		Consumer<ConsumerMovie> c3 = m -> System.out.println(m.name + " stored information in database");

		Consumer<ConsumerMovie> cc = c1.andThen(c2).andThen(c3);
		cc.accept(new ConsumerMovie("Spider"));
	}
}
