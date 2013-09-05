package com.sanjeeb.spring1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataClassTest {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/spring-context-1.xml");
		DataClass dataClass = (DataClass)factory.getBean("dataClass");
		System.out.println(dataClass.toString());
	}
}
class DataClass {
	public Integer getIntegerData() {
		return integerData;
	}
	public void setIntegerData(Integer integerData) {
		this.integerData = integerData;
	}
	public Float getFloatData() {
		return floatData;
	}
	public void setFloatData(Float floatData) {
		this.floatData = floatData;
	}
	public Double getDoubleData() {
		return doubleData;
	}
	public void setDoubleData(Double doubleData) {
		this.doubleData = doubleData;
	}
	public String getStringData() {
		return stringData;
	}
	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	public List<String> getListData() {
		return listData;
	}
	public void setListData(List<String> listData) {
		this.listData = listData;
	}
	public Map<Integer, String> getMapData() {
		return mapData;
	}
	public void setMapData(Map<Integer, String> mapData) {
		this.mapData = mapData;
	}
	Integer integerData;
	Float floatData;
	Double doubleData;
	String stringData;
	List<String> listData;
	Map<Integer, String> mapData;
	
	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		bldr.append("integerData = " + integerData + "\n");
		bldr.append("floatData = " + floatData + "\n");
		bldr.append("doubleData = " + doubleData + "\n");
		bldr.append("listData = ");
		for(String str : listData) {
			bldr.append(str + "\t");
		}
		bldr.append("\n");
		bldr.append("mapdata = ");
		for(Integer key : mapData.keySet()) {
			bldr.append(key + ":" + mapData.get(key) + "\t");
		}
		bldr.append("\n");
		return bldr.toString();
		
	}
}