package com.hs.enumm;

class EnumOuter {
	public static enum InnerEnum {
		SUN, MON {
			public void test() {
				System.out.println("test method");
			}
		},
		TUE("ABC"), WED;
		String s = null;
		
		InnerEnum(String s) {
			this.s = s;
			System.out.println("ABC construtor");
		}

		InnerEnum() {
			System.out.println("default constructor");
		}

		public String getValue() {
			return s;
		}
	}
}

public class EnumCheck {
	public static void main(String[] args) {
		EnumOuter.InnerEnum innerEnum = EnumOuter.InnerEnum.TUE;
		System.out.println(innerEnum);
		System.out.println(innerEnum.getValue());
		//EnumOuter.InnerEnum inner = EnumOuter.InnerEnum.MON;
		//System.out.println(inner.toString());
	}
}