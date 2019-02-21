package com.hs.inter.exp;

import java.util.HashMap;
import java.util.Map;

public class EqualsChekc {
	Integer k;

	public EqualsChekc(Integer k) {
		this.k = k;
	}

	@Override
	public boolean equals(Object o) {
		System.out.println(((EqualsChekc) o).k == this.k);
		return ((EqualsChekc) o).k == this.k;
	}

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		EqualsChekc c1 = new EqualsChekc(1);
		EqualsChekc c2 = new EqualsChekc(2);
		EqualsChekc c3 = new EqualsChekc(3);
		EqualsChekc c4 = new EqualsChekc(new Integer(4));

		map.put("one", c1);
		map.put("two", c2);
		map.put("one", c3);
		map.put("two", c4);

		System.out.println(map.size());
	}
}
