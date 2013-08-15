package com.sanjeeb.designs.callcenter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CallHandlerSystem {
	
	Queue<Respondent> respondentQueue;
	Queue<Manager> managerQueue;
	Queue<Director> directorQueue;
	Queue<Call> respondentCallQueue, managerCallQueue, directorCallQueue;
	
	public void addCallToTheQueue(String callerName) {
		respondentCallQueue.add(new Call(callerName, EmployeeRank.RESPONDENT));
	}
	
	public void startBusiness(int i, int j) {
		new QueueScanner(respondentCallQueue).start();
		new QueueScanner(managerCallQueue).start();
		new QueueScanner(directorCallQueue).start();
	}
	
	private void dispatchCall(Call call) {
		new CallDispatcher(call, this).start();
	}

	class QueueScanner extends Thread {
		private Queue<Call> queue;
		public QueueScanner(Queue<Call> queue) {
			this.queue = queue;
		}
		@Override
		public void run(){
			//do {
				Iterator<Call> ite = queue.iterator();
				while(ite.hasNext()) {
					Call call = ite.next();
					dispatchCall(call);
				}
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			//} while (true);
		}
	}
	class CallDispatcher extends Thread {
		private Call call;
		CallHandlerSystem system;
		public CallDispatcher(Call call, CallHandlerSystem system) {
			this.call = call;
			this.system = system;
		}
		
		@Override
		public void run() {
			Employee handlingEmployee = getCallReceiver(call);
			while(handlingEmployee == null) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				handlingEmployee = getCallReceiver(call);
			}
			handlingEmployee.receiveCall(call, system);
		}
	}
	
	public void recycleEmployee(Employee employee) {
		employee.callCurrentlyHandling = null;
		switch(employee.employeeRank) {
		case RESPONDENT :
			respondentQueue.add((Respondent)employee);
			break;
		case MANAGER :
			managerQueue.add((Manager)employee);
			break;
		case DIRECTOR :
			directorQueue.add((Director) employee);
		}
	}
	public void handleEscalatedCall(Call call) {
		switch(call.getHandleRank()) {
		case MANAGER :
			managerCallQueue.add(call);
			break;
		case DIRECTOR : 
			directorCallQueue.add(call);
			break;
		default :
			respondentCallQueue.add(call);
			//piss customer off
			break;
		}
	}
	
	
	private static CallHandlerSystem instance;
	private CallHandlerSystem(){
		respondentQueue = new LinkedList<Respondent>();
		managerQueue = new LinkedList<Manager>();
		directorQueue = new LinkedList<Director>();
		initializeEmployeeQueue();
		
		respondentCallQueue = new LinkedList<>();
		managerCallQueue = new LinkedList<>();
		directorCallQueue = new LinkedList<>();
	}
	
	private Employee getCallReceiver(Call call) {
		switch (call.getHandleRank()) {
		case RESPONDENT :
			if(!respondentQueue.isEmpty()) {
				return respondentQueue.remove();
			} else {
				respondentCallQueue.add(call);
			}
				
			break;
		case MANAGER :
			if(!managerQueue.isEmpty()) {
				return managerQueue.remove();
			} else {
				managerCallQueue.add(call);
			}
				
			break;
		case DIRECTOR :
			if(!directorQueue.isEmpty()) {
				return directorQueue.remove();
			} else {
				directorCallQueue.add(call);
			}
			break;
		}
		return null;
	}
	
	private void initializeEmployeeQueue() {
		// Error check
		// 10 respondents, 4 managers & 2 directors
		for(int i = 1; i <= 10; ++i) 
			respondentQueue.add(new Respondent(Integer.toString(i), "Respondent" + Integer.toString(i)));
		for(int i = 1; i <= 4; ++i) 
			managerQueue.add(new Manager(Integer.toString(i), "Manager"+Integer.toString(i)));
		for(int i = 1; i <= 2; ++i) {
			directorQueue.add(new Director(Integer.toString(i), "Director"+Integer.toString(i)));
		}
	}
	
	public static CallHandlerSystem getInstance() {
		if(instance == null) {
			instance = new CallHandlerSystem();
		}
		return instance;
	}
}