package com.sanjeeb.java.concepts;

public class SumOfDigitsInANumber {
	public static void main(String[] args) {
		int number = 23456;
		System.out.println("Sum of digits in " + number + " is " + getSum(number));
	}

	public static int getSum(int number) {
		if(number < 10) return number;
		return getSum(number, getLargestDivisor(number), 0);
	}
	
	private static int getLargestDivisor(int num) {
		int divisor = 10;
		while( num/divisor > 9) {
			divisor*=10;
		}
		return divisor;
	}
	
	private static int getSum(int number, int currentDivisor, int interimSum) {
		if(number < 10) return interimSum + number;
		return getSum(number%currentDivisor, currentDivisor/10, interimSum + number/currentDivisor);
	}
}
