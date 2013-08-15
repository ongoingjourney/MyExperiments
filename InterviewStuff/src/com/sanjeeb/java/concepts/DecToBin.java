package com.sanjeeb.java.concepts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DecToBin {
	public static void main(String[] args) {
		int decNum = 133;
		List<Integer> binNum = getBin(decNum);
		System.out.print("Binary of " + decNum + " is ");
		for(Integer temp : binNum){
			System.out.print(temp + " ");
		}
	}
	private static List<Integer> getBin(int num) {
		//check conditions
		List<Integer> bin = new LinkedList<>();
		do {
			bin.add(num %2);
			num/=2;
		} while(num>1);
		bin.add(1);
		Collections.reverse(bin);
		return bin;
	}
}