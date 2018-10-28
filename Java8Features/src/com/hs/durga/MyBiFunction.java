package com.hs.durga;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

class BiFunctionEmployee {
	String name;
	int salary;

	public BiFunctionEmployee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
}

public class MyBiFunction {
	public static void main(String[] args) {
		List<BiFunctionEmployee> list = new ArrayList<>();
		BiFunction<String, Integer, BiFunctionEmployee> biFunction = (name, salary) -> new BiFunctionEmployee(name,
				salary);
		list.add(biFunction.apply("Hare", 100));
		list.add(biFunction.apply("Raghu", 500));
		for (BiFunctionEmployee e : list) {
			System.out.println(e.name);
		}
	}
}
