package com.sanjeeb.problemsolving.concepts;

public class DataTypesTest {
	public static void main(String[] args) {
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(.9f-.11f);
		int j = 17>>3;
		System.out.println(j);
		
		StringBuilder bldr = new StringBuilder("abc");
		bldr.append(1);
		bldr.append(35f/3f);
		System.out.println(bldr);
		
		
		int[] arr = new int[10];
		int[] newArr = {1,2,3};
		String switcher = "red";
		switch(switcher) {
			case "red" :
			{
				System.out.println("it's red");
				break;
			}
			case "yello" :
			{
				System.out.println("its " + switcher);
				break;
			}
			
			default :
			{
				System.out.println("none");
				break;
			}
		}
	}
}