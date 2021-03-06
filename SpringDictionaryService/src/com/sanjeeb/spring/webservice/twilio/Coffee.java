package com.sanjeeb.spring.webservice.twilio;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "coffee")
public class Coffee {
	
	String name;
	int quanlity;
 
	public String getName() {
		return name;
	}
 
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuanlity() {
		return quanlity;
	}
 
	@XmlAttribute
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
 
	public Coffee(String name, int quanlity) {
		this.name = name;
		this.quanlity = quanlity;
	}
 
	public Coffee() {
	}
}