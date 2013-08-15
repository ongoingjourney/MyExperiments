package com.sanjeeb.problemsolving;

public class Test
 {
	public static void main(String[] args) {
//		testBlock();
//		testAnother(1);
//		testAnother(1, 2);
//		testAnother(1, 2, 3, 4);
		testBlock();
	}

	private static void testAnother(int ... args ) {
		System.out.println(args.length);
	}

	private static void testBlock() {
		String className = "com.sanjeeb.problemsolving.StringToLong";
		try {
			Class stToLong = Class.forName(className);
			StringToLong st = (StringToLong)(stToLong.newInstance());
			st.test();
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
			ex.printStackTrace();
		}
	}
 }	
	