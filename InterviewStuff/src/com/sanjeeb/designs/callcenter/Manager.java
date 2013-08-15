package com.sanjeeb.designs.callcenter;

import java.util.Random;

public class Manager extends Employee {
	public Manager(String employeeID, String employeeName) {
		callCurrentlyHandling = null;
		employeeRank = EmployeeRank.MANAGER;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}
	@Override
	public void escalateCall(Call call, CallHandlerSystem callHandlerSystem) {
		call.setCallStatus(CallStatus.ESCALATED);
		call.setHandleRank(EmployeeRank.DIRECTOR);
		callHandlerSystem.handleEscalatedCall(call);
		callHandlerSystem.recycleEmployee(this);
	}
	
	@Override
	public void receiveCall(Call call, CallHandlerSystem callHandlerSystem) {
		if(new Random().nextInt() % 2 == 0)
			escalateCall(call, callHandlerSystem);
		call.setCallStatus(CallStatus.RESOLVED);
		completeCall(call, callHandlerSystem);
	}
}
