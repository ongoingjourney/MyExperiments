package com.sanjeeb.java.concepts;

public class OverrideMethod {

}

class parento {
	int testMethod(long aLong, int string) {
		System.out.println("from Parent");
		return 0;
	}
}
class childo extends parento{
	 int testMethod(long aLong, int string) {
		System.out.println("fron child");
		return 0;
	}
}