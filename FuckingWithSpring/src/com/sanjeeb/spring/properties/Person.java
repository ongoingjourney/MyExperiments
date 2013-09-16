package com.sanjeeb.spring.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	String name;
	int age;
	char sex;
	String random;
	List<String> randomList;
	
	public Person(String name, int age, char sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		bldr.append("name : " + name + "\n")
			.append("sex : " + sex + "\n")
			.append("age : " + age + "\n")
			.append("random : " + random + "\n")
			.append("randomList : [");
		for(String str : randomList) {
			bldr.append(str);
		}
		bldr.append("]");
		return bldr.toString(); 
	}

	public List<String> getRandomList() {
		return randomList;
	}

	public void setRandomList(List<String> randomList) {
		this.randomList = randomList;
	}
}