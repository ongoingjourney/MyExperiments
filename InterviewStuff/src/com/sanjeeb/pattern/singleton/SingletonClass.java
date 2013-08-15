package com.sanjeeb.pattern.singleton;

public class SingletonClass {
	private static SingletonClass testClass;
	
	private SingletonClass(){
	}
	
	public static synchronized SingletonClass getInstance() {
		if(testClass == null) {
			testClass = new SingletonClass();
		}
		return testClass;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		throw new CloneNotSupportedException("Sorry");
	}
	
	private void sayHi() {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		try {
		String className = "com.sanjeeb.pattern.singleton.SingletonClass";
		
		Class cl1 = (Class)Class.forName(className);
		SingletonClass singleClas1 = (SingletonClass)cl1.newInstance();
		
		Class cl2 = (Class)Class.forName(className);
		SingletonClass singleClas2 = (SingletonClass)cl1.newInstance();
		
		System.out.println(cl1==cl2);
		System.out.println(cl1.equals(cl2));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}