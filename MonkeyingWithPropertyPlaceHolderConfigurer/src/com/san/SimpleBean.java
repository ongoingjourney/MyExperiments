package com.san;

import java.util.List;

public class SimpleBean {
	int id;
	String name;
	List<String> interests;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInterests() {
		return interests;
	}
	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	@Override
	public String toString () {
		return "name : "  + name + "\t id : " + id; 
	}
}