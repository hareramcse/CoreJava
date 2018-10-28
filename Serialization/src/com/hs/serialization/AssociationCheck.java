package com.hs.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Associated {

}

class Association implements Serializable {
	private static final long serialVersionUID = 1L;

	Associated associated = new Associated();
}

public class AssociationCheck {
	public static void main(String[] args) throws IOException {

		Association association = new Association();

		try (FileOutputStream fos = new FileOutputStream("association.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(association);
			oos.flush();
			oos.close();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}