package com.sanjeeb.problemsolving;
/**
 * Question - Given a string, write a routine that converts the string to a long, 
 * without using the built in functions that would do this.
 *
 */
public class StringToLong {
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static void main(String[] args) {
		StringToLong converter = new StringToLong();
		converter.test();
	}
	
	/**
	 * Test methods to include various input
	 */
	public void test()	{
		// Test input values.
		String[] testInputList = new String[]{"-", "+", "=", null, "", "-1S3", "-123", "+123", "123", 
				Long.toString(Long.MAX_VALUE), Long.toString(-1*(Long.MIN_VALUE - 1))};
		
		for(int i = 0; i < testInputList.length; ++i) {
			try {
				System.out.println(stringToLong(testInputList[i]));
			} catch (NumberFormatException ex) 
			{
				//send this statement to log. 
				System.out.println("[" + testInputList[i] + "]\t" + ex.toString());
			}
		}		
	}
	
	/**
	 * The public method to convert string to long.
	 * @param s string that needs to be converted to long.
	 * @return returns numeric value of the string supplied if possible.
	 */
	public long stringToLong(String s){
		validateLongString(s);
		return converStringToLong(s); 
	}
	
	
	/**
	 * Check if the input string can be converted to a valid number. 
	 * Could have use java's regex, but avoiding that to show validation details.
	 * This method extracts any - or + sign, if it exists, in the beginning of the string, 
	 *  and then validates rest of the string for numerical value.
	 * @param s the string that needs to be converted to long  
	 * @return true if the non-empty string comprises of all numbers.
	 */
	private void validateLongString(String s) {
		// invalid if it's a null or empty string 
		if(s == null || s.length() <1)
			throw new NumberFormatException ("Input string cannont be null or empty");
		
		int firstNumericalIndex = getIndexOfFirstNumber(s);
		
		// invalid if the only character in the string is + or - sign. 
		if(firstNumericalIndex == 1 && s.length() == 1) 
			throw new NumberFormatException ("Input string cannot be just + or -");
	
		// invalid if it's a non digit character [0-9]. Could have used a regex.
		for(int i = firstNumericalIndex; i < s.length(); ++i) {
			char currentChar = s.charAt(i);
			if(currentChar < '0' || currentChar > '9')
				throw new NumberFormatException ("Non-numeric character " + currentChar + " found" );
		}
	}
	
	/**
	 * Internal method that actually supplied numerical string to long.
	 * Algorithm - 
	 * 		Extact out the sign character, if one exists.
	 * 		longVal <- 0
	 * 		for i<-indexOfFirstNumber to length of string.
	 * 			longVal <- longVal*10 + numericalValueOfCharacter at i
	 *   
	 * @param s - string.  
	 * @return long value of string s.
	 */
	private long converStringToLong(String s) {
		Long longVal = 0L;
		int firstNumericalIndex = getIndexOfFirstNumber(s);
		for(int i = firstNumericalIndex; i <s.length(); ++i) {
			longVal = longVal*10 + (s.charAt(i)-'0');
			if(longVal < 0) {
				throw new NumberFormatException("supplied string is too large to convert");
			}
		}
		return (firstNumericalIndex == 1 && s.charAt(0) == '-') ? -1*longVal : longVal; 
	}
	
	/**
	 * Helper to identify if supplied string has a '-' or '+' sign in the beginning.
	 * @param s input numerical string
	 * @return 1 if string starts with '+' or '-' sign. 0 otherwise. 
	 */
	private int getIndexOfFirstNumber(String s) {
		if(s.charAt(0) == '-' || s.charAt(0) == '+') 
				return 1;
		return 0;
	}
}

/*
Output
[-]	java.lang.NumberFormatException: Input string cannot be just + or -
[+]	java.lang.NumberFormatException: Input string cannot be just + or -
[=]	java.lang.NumberFormatException: Non-numeric character = found
[null]	java.lang.NumberFormatException: Input string cannont be null or empty
[]	java.lang.NumberFormatException: Input string cannont be null or empty
[-1S3]	java.lang.NumberFormatException: Non-numeric character S found
-123
123
123
9223372036854775807
-9223372036854775807
*/