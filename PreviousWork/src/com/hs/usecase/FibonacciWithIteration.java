package com.hs.usecase;

public class FibonacciWithIteration {
	public int printSeries(int n){
		int x=1;
		for(int i=1;i<=n;i++){
			x=x*i;
		}
		System.out.println(x);
		return x;
	}

	public static void main(String[] args) {
		FibonacciWithIteration fi=new FibonacciWithIteration();
		fi.printSeries(5);
	}
}
