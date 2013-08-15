package com.sanjeeb.designs.callcenter;

public class Director extends Employee {
	public Director(String employeeID, String employeeName) {
		callCurrentlyHandling = null;
		employeeRank = EmployeeRank.DIRECTOR;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}
	@Override
	public void escalateCall(Call call, CallHandlerSystem callHandlerSystem) {
		//cant escalate.
	}
	
	@Override
	public void receiveCall(Call call, CallHandlerSystem callHandlerSystem) {
		completeCall(call, callHandlerSystem);
		call.setCallStatus(CallStatus.RESOLVED);
	}
}
