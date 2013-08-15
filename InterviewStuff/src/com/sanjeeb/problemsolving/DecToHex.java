package com.sanjeeb.problemsolving;

public class DecToHex {
	public static void main(String[] args) {
		for(int i = 0; i < 256;++i) {
			System.out.println(i + ":" + getHex(i));
		}
	}
	public static String getHex(int decVal) {
		StringBuilder bldr = new StringBuilder();
		int numberOfDigits = 1;
		while (decVal > Math.pow(16, numberOfDigits)-1) {
			++numberOfDigits;
		}
		
		int hexMultiplier = new Double(Math.pow(16, numberOfDigits-1)).intValue();

		for (int i = 0; i < numberOfDigits ; ++i) {
			int quot = decVal/hexMultiplier;
			bldr.append(getHexDigit(quot));
			decVal = decVal % hexMultiplier;
			hexMultiplier/= 16;
		}
		return bldr.toString();
	}
	private static String getHexDigit(int decDigit) {
		String hexDigit = "";
		if(decDigit > -1 && decDigit < 10) {
			hexDigit = String.valueOf(decDigit);
		} else if(decDigit == 10) {
			hexDigit = "A";
		} else if (decDigit == 11) {
			hexDigit = "B";
		}else if (decDigit == 12) {
			hexDigit = "C";
		}else if (decDigit == 13) {
			hexDigit = "D";
		}else if (decDigit == 14) {
			hexDigit = "E";
		}else if (decDigit == 15) {
			hexDigit = "F";
		}
		return hexDigit;
	}
	
}