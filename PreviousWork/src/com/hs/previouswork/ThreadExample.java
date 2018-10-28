package com.hs.previouswork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class FirstThread extends Thread{
	FileWriter f1 = null;
	BufferedWriter bw = null;
	public void run(){/*
		try {
			f1 = new FileWriter("text.txt");
			bw = new BufferedWriter(f1);
			bw.write("my name is khan");
			bw.newLine();
			bw.write("and i am not a terrorist");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(f1 != null){
				f1.close();
				}
				if(bw != null){
				bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	*/System.out.println("thread 1");
		for(int i=1;i<100;i++){
			System.out.println(i);
		}
		
	}
}
class SecondThread extends Thread{
	FileReader fr = null;
	BufferedReader br = null;
	public void run(){/*
		
		try {
			fr = new FileReader("text.txt");
			br =  new BufferedReader(fr);
			for (String line = br.readLine(); line != null; line = br.readLine()) {
			       System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/System.out.println("thread 2");
		for(int i=1;i<100;i++){
			System.out.println(i);
		}
		
	}
}

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		FirstThread f1 = new FirstThread();
		f1.start();
		//Thread.sleep(1000);
		
		/*SecondThread s1 = new SecondThread();
		s1.start();*/
		f1.join();
		System.out.println("main start");
		for(int i=1;i<100;i++){
			System.out.println(i);
		}
		System.out.println("Main end");
	}
}
