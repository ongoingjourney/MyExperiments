package com.sanjeeb.problemsolving;

public class PrimeNumberChecker {
	public static void main(String[] args) {
		int upperLimit = 2337;
		for(int i = -1; i <= upperLimit; ++i) {
			boolean result = isPrime (i);
			if(result) {
				System.out.print(i + "\t");
			}
		}
	}
	
	public static boolean isPrime(int number) {
		if(number < 2) return false;
		if(number == 2 || number == 3) return true;
		return isPrime(number, 2);
	}
	
	private static boolean isPrime(int number, int curDivisor) {
		if(curDivisor > number/2) 
			return false;
		
		if(curDivisor == number/2 && number % curDivisor != 0) 
			return true;
		
		if(number % curDivisor == 0) {
			return false;
		} 
		
		return isPrime(number, curDivisor + 1);
	}
}
