package com.hs.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* 
 Java serialization keeps a record of every object written to a stream. If the same object is encountered second 
 time, only a reference is written to the stream, and not a second copy of the object; so circular references aren't
 the problem here.But serialization is vulnerable to stack overflow for certain kinds of structures; for example, a 
 long linked list with no special writeObject() methods will be serialized by recursively writing each link. If 
 you've got a 100,000 links, you're going to try to use 100,000 stack frames, and quite likely fail with a 
 StackOverflowError.It's possible to define a writeObject() method for such a list class that, when the first link 
 is serialized, simply walks the list and serializes each link iteratively; this will prevent the default recursive
 mechanism from being used.
 */

class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	List<Doctore> doctorList;

	public void setDoctorList(List<Doctore> doctorList) {
		this.doctorList = doctorList;
	}

	public List<Doctore> getDoctorList() {
		return doctorList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Doctore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	List<Patient> patientList;

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class CyclickSerialization {
	public static void main(String[] args) {
		List<Doctore> doctorList = new ArrayList<Doctore>();
		List<Patient> patientList = new ArrayList<Patient>();
		for (int i = 0; i < 1000; i++) {
			Patient patient = new Patient();
			patient.setName("Ram");
			patient.setAge(12);
			patient.setDoctorList(doctorList);
			patientList.add(patient);
		}
		for (int i = 0; i < 10000; i++) {
			Doctore doctore = new Doctore();
			doctore.setName("Ram");
			doctore.setAge(20);
			doctore.setPatientList(patientList);
			doctorList.add(doctore);
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("doctorPatient.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(patientList);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in doctorPatient.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}