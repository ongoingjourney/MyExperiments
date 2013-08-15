package com.sanjeeb.problemsolving;

public class DupeDetector {

	public static void main(String[] args) {
		int storage = 0;
		String stringToBeTested = null;
		if(stringToBeTested == null || stringToBeTested.length()<1) {
			System.out.println("String is null or empty");
			System.exit(0);
		}
		for(int i = 0; i < stringToBeTested.length(); ++i)
		{
			char currentChar = stringToBeTested.charAt(i);
			int position = currentChar - 'a';
			int temp = 1 << position;
			if((storage & temp) == 0){
				storage = storage|temp;
			} else {
				System.out.println("The duplicate character is " + (char)('a' + position));
			}
		}
	}
}