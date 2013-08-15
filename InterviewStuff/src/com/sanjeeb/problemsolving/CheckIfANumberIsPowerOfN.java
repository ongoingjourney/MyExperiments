package com.sanjeeb.problemsolving;

public class CheckIfANumberIsPowerOfN {
	public static void main(String[] args) {
		int range = Integer.MAX_VALUE;
		int num = 6;
		for(int i = 1; i < range; i++) {
			if(isNumPowOfBaseNum(i, num))
				System.out.println(i);
		}
	}
	
	public static boolean isNumPowOfBaseNum(int num, int baseNum) {
		if(num == baseNum) return true;
		for(int i = 1; i < baseNum; ++i) 
			if(num%baseNum == i) 
				return false;
		return isNumPowOfBaseNum(num/baseNum, baseNum);
	}
}

