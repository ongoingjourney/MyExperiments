package com.sanjeeb.designs.callcenter;

public class Call {
	String caller;
	Employee handler;
	EmployeeRank handleRank;
	CallStatus callStatus;
	//Escalation note

	public Call(String caller, EmployeeRank handleRank) {
		this.caller = caller;
		this.handleRank = handleRank;
		this.callStatus = CallStatus.NEW;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public Employee getHandler() {
		return handler;
	}

	public void setHandler(Employee handler) {
		this.handler = handler;
	}

	public EmployeeRank getHandleRank() {
		return handleRank;
	}

	public void setHandleRank(EmployeeRank handleRank) {
		this.handleRank = handleRank;
	}

	public CallStatus getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(CallStatus callStatus) {
		this.callStatus = callStatus;
	}
}