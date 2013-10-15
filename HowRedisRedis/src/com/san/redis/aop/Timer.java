package com.san.redis.aop;

public interface Timer {
	public void startTimeTracking();
	public void stopTimeTracking();
	public void resetTimeTracking();
}