package com.sanjeeb.java.concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OverrideEqualsAndHashCode {
	public static void main(String[] args) {
		Map<Person, Integer> aMap = new HashMap<>();
		Person p1 = new Person("Jack", 22);
		Person p2 = new Person( "Daniel", 22);
		aMap.put(p1, new Integer(1));
		aMap.put(p2, new Integer(3));
		
		System.out.println(p1.equals(p2));
		
		Set<Person> keys = aMap.keySet();
		for(Person p : keys) {
			System.out.println((Integer)aMap.get(p));
		}
	}
}

class Person {
	String name;
	int age;
	public Person(String aName, int anAge) {
		this.name = aName;
		this.age = anAge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null) 
			return false;
		
		if(obj.getClass() != this.getClass())
			return false;
		
		Person pers = (Person)obj;
		return pers.getAge() == this.getAge();
	}
	
	@Override
	public int hashCode(){
		return this.age;
	}
}