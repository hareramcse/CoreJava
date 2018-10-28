package com.hs.durga;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MyFourthStream {
	public static void main(String[] args) {
		List<Integer> marks = new ArrayList<>();
		marks.add(10);
		marks.add(11);
		marks.add(12);
		marks.add(13);
		marks.add(14);
		marks.add(15);
		marks.stream().forEach(System.out::println);
		Consumer<Integer> consumer = i -> System.out.println("square of the " + i + " is " + (i * i));
		marks.stream().forEach(consumer);

		Integer[] i = marks.stream().toArray(Integer[]::new);
		Stream.of(i).forEach(System.out::println);
		Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
		stream.forEach(System.out::println);

	}
}
