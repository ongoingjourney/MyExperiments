package com.sanjeeb.java.concepts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPattern {
	public static void main(String[] args) {
		
		match("[a-cA-D]", "A");
		match("[a-cA-D]", "aD");
		match("[a-cA-D]{2}", "aD");
		match("a*D", "aasdfasdfD");
		match("a[a-zA-Z]*D", "aasdfasdfD");
		parseDate("03-jun-2011");
	}
	
	private static void parseDate(String str) {
		String regex = "(\\d{2})-([a-zA-Z]{3})-(\\d{4})";
		Pattern patten = Pattern.compile(regex);
		Matcher matcher = patten.matcher(str);
		if(matcher.matches()) {
			for(int i = 0; i <= matcher.groupCount(); ++i)
				System.out.println(i + ":" + matcher.group(i));
		}
	}
	private static void match(String regex, String str) {
		Pattern patten = Pattern.compile(regex);
		Matcher matcher = patten.matcher(str);
		System.out.println("[" + matcher.matches() + "] -> " + regex + ":" + str);
	}
}
