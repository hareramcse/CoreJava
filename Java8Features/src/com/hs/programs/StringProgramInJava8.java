package com.hs.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringProgramInJava8 {
	public static void main(String[] args) {
		String str = "ilovejavatechie";
		String[] arr = str.split("");

		System.out.println("prints the char and its count");
		Map<String, Long> map = Stream.of(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		System.out.println("print the chars whose count is > 1");
		Stream<Entry<String, Long>> filter = Stream.of(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(a -> a.getValue() > 1);
		List<String> res = filter.map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(res);

		System.out.println("prints the 1st non repeating char");
		Stream<Entry<String, Long>> filter2 = Stream.of(arr)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(a -> a.getValue() == 1);
		filter2.map(Map.Entry::getKey).findFirst().ifPresent(a -> System.out.println(a));

		System.out.println("print 2nd biggest number");
		int[] arr1 = { 12, 11, 5, 6, 8, 3, 4 };
		IntStream.of(arr1).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.ifPresent(a -> System.out.println(a));

		System.out.println("Find the longest string");
		String[] strs = { "Java", "Techie", "Springboot", "Microservices" };
		String string = Arrays.stream(strs).reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println(string);
	}
}