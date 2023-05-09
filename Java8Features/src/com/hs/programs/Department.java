package com.hs.programs;

public class Department {
	public int deptId;
	public String deptName;
	public int noOfEmployee;

	public Department(int deptId, String deptName, int noOfEmployee) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.noOfEmployee = noOfEmployee;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}
}