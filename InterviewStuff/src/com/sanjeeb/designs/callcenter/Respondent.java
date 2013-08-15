package com.sanjeeb.designs.callcenter;

import java.util.Random;

public class Respondent extends Employee {
	public Respondent(String employeeID, String employeeName) {
		callCurrentlyHandling = null;
		employeeRank = EmployeeRank.RESPONDENT;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}
	@Override
	public void escalateCall(Call call, CallHandlerSystem callHandlerSystem) {
		call.setHandleRank(EmployeeRank.MANAGER);
		call.setCallStatus(CallStatus.ESCALATED);
		callHandlerSystem.handleEscalatedCall(call);
		callHandlerSystem.recycleEmployee(this);
	}
	@Override
	public void receiveCall(Call call, CallHandlerSystem callHandlerSystem) {
//		if(new Random().nextInt() %2 == 1){
//			escalateCall(call, callHandlerSystem);
//		}
		call.setCallStatus(CallStatus.RESOLVED);
		completeCall(call, callHandlerSystem);
		System.out.println(this.getEmployeeID() + "successfully handled call from " + call.getCaller());
	}
}
