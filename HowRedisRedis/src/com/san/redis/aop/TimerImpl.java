package com.san.redis.aop;

public class TimerImpl implements Timer{

	@Override
	public void startTimeTracking() {
		System.out.println("Start the timer.");
	}

	@Override
	public void stopTimeTracking() {
		System.out.println("Stop timer.");
	}

	@Override
	public void resetTimeTracking() {
		System.out.println("Reset timer.");
	}
}