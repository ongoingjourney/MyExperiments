package com.sanjeeb.spring.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Entity")
public class Entity {
	private String word;
	private String definition;

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}	
	@Override
	public String toString() {
		return "[" + word + " = " + definition + "]";
	}
}