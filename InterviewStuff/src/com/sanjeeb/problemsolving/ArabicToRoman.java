package com.sanjeeb.problemsolving;

import java.security.InvalidParameterException;
import java.util.Random;

public class ArabicToRoman {

	public static void main(String[] args) {
//		int num = 3608;
//		System.out.println(num + ":" + getRomanNumeral(num));
//		
//		for(int i = 1; i < 20; ++i)
//			System.out.println(i + " : " + getRomanNumeral(i));
//		
		Random random = new Random();
		for(int i = 1; i < 14; ++i) {
			int num = random.nextInt() % 3999;
			num = num < 0 ? num*-1:num;
			System.out.println(num + ":" + getRomanNumeral(num));
		}
	}
	
	public static String getRomanNumeral(int num){
		if(num < 1 || num > 3999) {
			throw new InvalidParameterException("Number out of range");
		}
		int multiplier = 1;
		String romanNumber = "";
		do {
			int switcher = num%10;
			int size = 1 * multiplier;
			switch(switcher) {
				case 1:
				case 2:
				case 3: 
				{
					String symbol = RomanNumerals.getRoman(size); 
					for(int temp = 0; temp < switcher; ++temp) {
						romanNumber = symbol + romanNumber;
					}
					break;
				}
				case 4: 
				{
					romanNumber = RomanNumerals.getRoman(size) + RomanNumerals.getRoman(size*5) + romanNumber;
					break;
				}
				case 5 : 
				{
					romanNumber= RomanNumerals.getRoman(size*5) + romanNumber;
					break;
				}
				case 6 : 
				case 7 : 
				case 8 :  
				{
					String symbol = RomanNumerals.getRoman(size*5);
					for(int temp = 0; temp < switcher-5; ++temp) {
						symbol += RomanNumerals.getRoman(size);
					}
					romanNumber = symbol + romanNumber;
					break;
				}
				case 9:
				{
					romanNumber = RomanNumerals.getRoman(size) + RomanNumerals.getRoman(size*10) + romanNumber;
				}
			}
			num/=10;
			multiplier*=10;
		} while(num>0);
		
		return romanNumber;
	}
}

class RomanNumerals {
	public static String getRoman(int i)
	{
		String val = "";
		switch(i) {
			case 1 : {
				val = "I";
				break;
			}
			case 5 : {
				val = "V";
				break;
			}
			case 10 : {
				val = "X";
				break;
			}
			case 50 : {
				val = "L";
				break;
			}
			case 100 : {
				val = "C";
				break;
			}
			case 500 : {
				val = "D";
				break;
			}
			case 1000 : {
				val = "M";
				break;
			}
		}
		return val;
	}
 }