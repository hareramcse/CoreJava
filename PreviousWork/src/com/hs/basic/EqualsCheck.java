package com.hs.previouswork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class EqualCheck{
	int i;
	int j;
	public EqualCheck(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	@Override
	public int hashCode() {
		System.out.println("hashcode");
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EqualCheck other = (EqualCheck) obj;
		if (i != other.i) {
			return false;
		}
		if (j != other.j) {
			return false;
		}
		return true;
	}
	
	
}
public class EqualsCheck {
	public static void main(String[] args) {
		EqualCheck e1 = new EqualCheck(10, 20);
		EqualCheck e2 = new EqualCheck(10, 20);
		// here if we dont use hashmap or hashset or any hashing mechanism so  hashcode will not be called
		System.out.println(e1.equals(e2));
		System.out.println(".............");
		
		
		
		// here we are calling hash so hashcode will be called
		// here hashcode will be called for every entry and if the hashcode are same then only equals will be called
		// if hascode itself is different then equals will not be called
		// if both object are same then size wont increase( here in this case it would be 1 not 2)
		Map<EqualCheck, Integer> map=new HashMap<EqualCheck, Integer>();
		map.put(e1, 20);
		map.put(e2, 30);
		System.out.println(map.size());
		
		
		// here we are calling hash so hashcode will be called
		// here hashcode will be called for every entry and if the hashcode are same then only equals will be called
		// here hascode itself is different then equals will not be called
		// if both object are same then size wont increase( here in this case it would be 1 not 2)
		Set<EqualCheck> set=new HashSet<EqualCheck>();
		set.add(e1);
		set.add(e2);
		System.out.println(set.size());
	}
}
