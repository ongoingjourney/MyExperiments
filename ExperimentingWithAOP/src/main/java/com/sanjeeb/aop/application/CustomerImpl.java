package com.sanjeeb.aop.application;

public class CustomerImpl implements Customer {
    public void browse() {
        System.out.println("Customer is browsing internt");
        long sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            sum += i;
        }
        //throw new IllegalArgumentException("some shit");
    }
}