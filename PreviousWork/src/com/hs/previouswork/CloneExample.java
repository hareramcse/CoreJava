package com.hs.previouswork;

class Address {
	String street;
	String dist;
	String state;

	public Address(String street, String dist, String state) {
		super();
		this.street = street;
		this.dist = dist;
		this.state = state;
	}

	@Override
	public String toString() {
		return "" + street + "\t" + dist + "\t" + state;
	}
}

class Customer implements Cloneable {
	int cid;
	String cname;
	Address add;

	public Customer(int cid, String cname, Address add) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.add = add;
	}

	public Object shallowCloning() throws CloneNotSupportedException {
		return super.clone();
	}

	public Object deepCloning() throws CloneNotSupportedException {
		Object obj = null;
		if (this instanceof Cloneable) {
			Address add = new Address(this.add.street, this.add.dist,
					this.add.state);
			obj = new Customer(this.cid, this.cname, add);
		} else {
			return new CloneNotSupportedException();
		}
		return obj;
	}

	@Override
	public String toString() {
		return "" + cid + "\t" + cname + "\t" + add;
	}
}

public class CloneExample {
	public static void main(String[] args) throws CloneNotSupportedException {

		Address add = new Address("Bharkuriya", "Rohtas", "Bihar");
		Customer customer1 = new Customer(101, "Hareram", add);
		System.out.println(customer1);
		System.out.println();

		System.out.println("**After shallow cloning**");
		Customer customer2 = (Customer) customer1.shallowCloning();
		System.out.println("original copy : " + customer1);
		System.out.println("cloned copy : " + customer2);
		System.out.println();
		// Justification for shallow Cloning
		customer2.add.street = "BTM";// this line affect original object so
										// shallow cloning
		customer2.cname = "Raghu";
		System.out.println("after modification of cloned copy .....");
		System.out.println("Original object : " + customer1);
		System.out.println("Cloned object : " + customer2);
		System.out.println();

		System.out.println("**After Deep cloning**");
		Customer customer3 = (Customer) customer1.deepCloning();
		System.out.println("original object : " + customer1);
		System.out.println("cloned copy : " + customer3);
		System.out.println();
		// Justification for deep Cloning
		System.out.println("after modification of cloned copy");
		customer3.add.street = "Marathalli";// this line does not affect
											// original object so deep cloning
		customer3.cname = "Ajoy";
		System.out.println("Original object :" + customer1);
		System.out.println("Cloned object :" + customer3);
		System.out.println();
	}
}
