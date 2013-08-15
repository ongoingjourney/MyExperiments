package com.sanjeeb.pattern.visitor1;

public class Engine implements CarElement {
	String partName;
	
	public Engine(String partName) {
		this.partName = partName;
	}
	
	public String getPartName() {
		return partName;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}