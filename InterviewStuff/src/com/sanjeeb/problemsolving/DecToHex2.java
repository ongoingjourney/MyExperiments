package com.sanjeeb.problemsolving;

public class DecToHex2 {

	public static void main(String[] args) {
		for(int i = 0; i < 257; ++i) {
			System.out.println(i + ":" + getHex(i));
		}
	}
	public static String getHex(int num) {
		StringBuilder sb = new StringBuilder();
		int numOfChar = 1;
		int multiplier = 1;
		while(num > (multiplier*16-1)) {
			++numOfChar;
			multiplier*= 16;
		}
		
		for(int i = 1; i <= numOfChar; ++i) {
			int quot = num/multiplier;
			sb.append(getMatchingNum(quot));
			num-=multiplier*quot;
			multiplier/=16;
		}
		
		return sb.toString();
	}
	
	private static char getMatchingNum(int n) {
		if(n<0||n>15) throw new NumberFormatException();
		char retVal = (char)((int)'0'+n);
		if(n>9) {
			retVal = (char)((int)'A'+(n-10));
		}
		return retVal;
	}
}
