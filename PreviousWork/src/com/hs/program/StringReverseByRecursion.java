package com.hs.program;

public class StringReverseByRecursion {
	 
    String reverse = "";
     
    public String reverseString(String str){
        if(str.length() == 1){
            return str;
        } else {
        	reverse += str.charAt(str.length()-1)
                    +reverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }
    public static void main(String a[]){
    	StringReverseByRecursion srr = new StringReverseByRecursion();
        System.out.println("Result: "+srr.reverseString("my name is khan and i am not a terrorist"));
    }
}