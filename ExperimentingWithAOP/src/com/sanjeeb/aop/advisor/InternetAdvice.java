package com.sanjeeb.aop.advisor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.sanjeeb.aop.concern.CafeOwner;

public class InternetAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {
	private CafeOwner cafeOwner;
	public CafeOwner getCafeOwner() {
		return cafeOwner;
	}

	public void setCafeOwner(CafeOwner cafeOwner) {
		this.cafeOwner = cafeOwner;
	}
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		getCafeOwner().LoginTime();
	}
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		getCafeOwner().Logout();
		
	}

	public void afterThrowing(Throwable throwable){
		getCafeOwner().cancelBilling();
	}
	
	//Executes around the method. 
	@Override
	public Object invoke(MethodInvocation methodArg) throws Throwable {
		System.out.println("Allocate a system to customer");
		methodArg.proceed();
		System.out.println("Deallocate system");
		this.getCafeOwner().prepareBill();
		return null;
	}
}