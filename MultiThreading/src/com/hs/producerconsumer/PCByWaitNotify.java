package com.hs.producerconsumer;

import java.util.ArrayList;
import java.util.List;

class Processor {
	List<Integer> list=new ArrayList<Integer>();
	public volatile int LIMIT=5;
	
	public void producer(){
		for(int i=0;i<=LIMIT;i++){
			synchronized (this) {
				if(list.size()==LIMIT){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.add(i);
				System.out.println(Thread.currentThread().getName()+" produce "+i);
				notify();
			}
		}
	}
	
	public void consumer(){
		while(true){
			synchronized (this) {
				if(list.size()==0){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(list.size()>0){
					int consume=list.remove(0);
					System.out.println(Thread.currentThread().getName()+" Consumer consumes "+consume);
				}
				notify();
			}
		}
	}
}

public class PCByWaitNotify {
	public static void main(String[] args) {
		final Processor p1=new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				p1.producer();
			}
		});
		t1.setName("producer thread 1");
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				p1.producer();
			}
		});
		t2.setName("producer thread 2");
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				p1.producer();
			}
		});
		t3.setName("producer thread 3");
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				p1.producer();
			}
		});
		t4.setName("producer thread 4");
		
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				p1.consumer();
			}
		});
		t5.setName("consumer thread 5");
		
		Thread t6 = new Thread(new Runnable() {
			public void run() {
				p1.consumer();
			}
		});
		t6.setName("consumer thread 6");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}