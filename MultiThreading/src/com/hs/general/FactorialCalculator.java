package com.hs.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Factorial implements Callable<Integer> {
	private Integer number;

	Factorial(Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;

		if ((number == 0) | (number == 1)) {
			return 1;
		} else {
			for (int i = 2; i <= number; i++) {
				result = result * i;
				TimeUnit.MILLISECONDS.sleep(10);
			}
		}
		System.out.println("Result for number " + number + " is " + result);
		return result;
	}

}

public class FactorialCalculator {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();

		Random random = new Random();

		for (int i = 0; i < 4; i++) {
			Integer number = random.nextInt(10);
			Factorial factorial = new Factorial(number);
			Future<Integer> result = executor.submit(factorial);
			resultList.add(result);
		}

		for (Future<Integer> future : resultList) {
			try {
				System.out.println("Future result is " + future.get() + " and task done is true");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

	}
}
