package com.hs.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

class BiConsumerEmployee {
	String name;
	int salary;

	public BiConsumerEmployee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
}

public class MyBiConsumer {
	public static void main(String[] args) {
		List<BiConsumerEmployee> list = new ArrayList<>();

		populate(list);

		BiConsumer<BiConsumerEmployee, Integer> biConsumer = (e, d) -> e.salary = e.salary + d;

		for (BiConsumerEmployee e : list) {
			biConsumer.accept(e, 500);
		}

		for (BiConsumerEmployee e : list) {
			System.out.println(e.name + " and " + e.salary);
		}
	}

	public static void populate(List<BiConsumerEmployee> list) {
		list.add(new BiConsumerEmployee("Hare", 100));
		list.add(new BiConsumerEmployee("Ram", 200));
	}
}
