package com.sanjeeb.pattern.visitor1;

public class Wheel implements CarElement {
	String partName;
	
	public Wheel(String partName) {
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
