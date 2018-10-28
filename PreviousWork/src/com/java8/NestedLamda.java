package com.java8;

@FunctionalInterface
interface customFunctiona {
	public customFunctiona run();
}

public class NestedLamda {
	int i;
	public static void main(String[] args) {
		customFunctiona m = () -> () -> () -> () -> null;
		System.out.println(m);
		
		customFunctiona m1 = () -> null;
		System.out.println(m1);
		System.out.println(m1.run());
		
		/*NestedLamda n = new NestedLamda();
		n.callRun();
		
		customFunctiona cm=new customFunctiona() {	
			@Override
			public void run() {
				System.out.println("annoynmous class " + this);				
			}
		};
		cm.run();*/
	}

	private void callRun() {
		//customFunctiona c=()->System.out.println("Helo by lamda " + this);
		//c.run();
	}
}
