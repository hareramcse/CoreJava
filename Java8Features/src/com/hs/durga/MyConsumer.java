package com.hs.durga;

import java.util.function.Consumer;

public class MyConsumer {
	public static void main(String[] args) {
		Consumer<String> consumer= s->System.out.println(s);
		consumer.accept("Hareram");
	}
}
