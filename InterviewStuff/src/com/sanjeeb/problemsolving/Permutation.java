package com.sanjeeb.problemsolving;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		List<String> strList = new LinkedList<String>();
		getPermutation("abcd", strList);
		for( int k = 0; k < strList.size(); ++k)
		{
			System.out.println(k+1 + ":" + strList.get(k));
		}
	}
	
	static void getPermutation(String str, List<String> strList) {
		// Do not allow str.length < 0 or null
		
		if (str.length() == 1){
			strList.add(str);
		} else if (str.length() == 2) {
			strList.add(Character.toString(str.charAt(0))+Character.toString(str.charAt(1)));
			strList.add(Character.toString(str.charAt(1))+Character.toString(str.charAt(0)));
		}
		else {
			for(int i = 0; i < str.length(); ++i)
			{
				if(i==0) {
					char ch = str.charAt(0);
					String st = str.substring(1, str.length());
					List<String> newList = new LinkedList<String>();
					getPermutation(st, newList);
					for(int j = 0; j < newList.size(); ++j)
					{
						strList.add(Character.toString(ch)+newList.get(j));
					}
				} else if(i==str.length()-1) {
					char ch = str.charAt(str.length()-1);
					String st = str.substring(0, str.length()-1);
					
					List<String> newList = new LinkedList<String>();
					getPermutation(st, newList);
					for(int j = 0; j < newList.size(); ++j)
					{
						strList.add(Character.toString(ch) + newList.get(j));
					}
				} else {
					char ch = str.charAt(i);
					String st = str.substring(0, i) + str.substring(i+1, str.length());

					List<String> newList = new LinkedList<String>();
					getPermutation(st, newList);
					for(int j = 0; j < newList.size(); ++j)
					{
						strList.add(Character.toString(ch)+ newList.get(j));
					}

					//return concatToArrayElement(ch, getPermutation(st));
				}
			}
		}
	}
	
	static String[] concatToArrayElement(char ch, String[] strArr){
		// Check strArr.
		String[] modifiedArr = new String[strArr.length];
		for(int i = 0; i < strArr.length; ++i)
		{
			modifiedArr[i] = ch + strArr[i];
		}
		return modifiedArr;
	}
	
	static String[] concatToArrayElement(String[] strArr, char ch){
		// Check strArr.
		String[] modifiedArr = new String[strArr.length];
		for(int i = 0; i < strArr.length; ++i)
		{
			modifiedArr[i] = strArr[i] + ch;
		}
		return modifiedArr;
	}
}