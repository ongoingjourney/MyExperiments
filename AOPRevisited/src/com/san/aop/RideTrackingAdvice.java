package com.san.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class RideTrackingAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {
	private Tracker tracker;

	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		tracker.startRouteTracking();
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		tracker.stopRouteTracking();
	}

	@Override
	public Object invoke(MethodInvocation methodArg) throws Throwable {
		System.out.println("Check airpressure in the tyre");
		methodArg.proceed();
		System.out.println("Congratulations. Hope you had a great ride");
		return null;
	}
	
	public void afterThrowing(Throwable throwable) {
		tracker.resetRouteTracking();
	}
}