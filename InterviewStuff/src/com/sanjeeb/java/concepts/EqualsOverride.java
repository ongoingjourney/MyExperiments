package com.sanjeeb.java.concepts;

public class EqualsOverride {
	public static void main(String[] args) {
		Person p1 = new Person("Hannah", 22);
		Person p2 = new Person("Hannah", 22);
		System.out.println(p1.equals(p2));
	}
}

//http://javarevisited.blogspot.sg/2011/02/how-to-write-equals-method-in-java.html
class Perso {
	public Perso(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	String name;
	int age;
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)  return true; 
		if(obj == null || obj.getClass() != this.getClass()) return false;
		Person guest = (Person)obj;
		return (name.equals(guest.name) && age==guest.age);
	}	
	@Override
	public int hashCode() {
		return name.length() + age;
	}
}