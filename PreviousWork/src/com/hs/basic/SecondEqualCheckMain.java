package com.hs.basic;

class EqulasCheck {
	int i;
	double d;

	public EqulasCheck(int i, double d) {
		this.i = i;
		this.d = d;
	}

	public String toString() {
		return "i= " + i + ", d= " + d;
	}

	@Override
	public int hashCode() {
		System.out.println("hashcode");
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(d);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqulasCheck other = (EqulasCheck) obj;
		if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
			return false;
		if (i != other.i)
			return false;
		return true;
	}

}

public class SecondEqualCheckMain {
	public static void main(String[] args) {
		EqulasCheck e1 = new EqulasCheck(9, 20.9);
		EqulasCheck e2 = new EqulasCheck(9, 20.9);
		System.out.println(e1.equals(e2));
	}
}
