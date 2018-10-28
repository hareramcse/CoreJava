package com.hs.durga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MySecondStream {
	public static void main(String[] args) {
		List<Integer> marks = new ArrayList<>();
		marks.add(10);
		marks.add(11);
		marks.add(12);
		marks.add(13);
		marks.add(14);
		marks.add(15);
		List<Integer> updatedMarks = marks.stream().map(i -> i + 5).collect(Collectors.toList());
		long count = marks.stream().filter(i -> i < 12).count();
		Optional<Integer> min=marks.stream().min((i1,i2)->i1.compareTo(i2));
		System.out.println(min.get());
		System.out.println(count);
		System.out.println(updatedMarks);
	}
}
