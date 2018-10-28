package com.hs.previouswork;

public class FindSingleElementInArray {
	int Singular(int[] arr)
	{
	    int value = 0;
	    for (int i = 0; i < arr.length; i++){
	        value = value ^ arr[i];
	    }
	    return value;
	}
	
	public static void main(String[] args) {
		FindSingleElementInArray fr=new FindSingleElementInArray();
		int arr[]={12,3,3,4,4,5,5};
		int result=fr.Singular(arr);
		System.out.println(result);
	}
}
