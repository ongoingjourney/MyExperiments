package com.sanjeeb.designs.callcenter;

public abstract class Employee {
	EmployeeRank employeeRank;
	Call callCurrentlyHandling;
	String employeeName;
	String employeeID;
	
	public abstract void receiveCall(Call call, CallHandlerSystem callHandlerSystem);
	
	public void completeCall(Call call, CallHandlerSystem callHandlerSystem) {
		callHandlerSystem.recycleEmployee(this);
	}
	
	public void escalateCall(Call call, CallHandlerSystem callHandlerSystem) {
		
	}

	public EmployeeRank getEmployeeRank() {
		return employeeRank;
	}

	public void setEmployeeRank(EmployeeRank employeeRank) {
		this.employeeRank = employeeRank;
	}

	public Call getCallCurrentlyHandling() {
		return callCurrentlyHandling;
	}

	public void setCallCurrentlyHandling(Call callCurrentlyHandling) {
		this.callCurrentlyHandling = callCurrentlyHandling;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
}
