package com.sanjeeb.pattern.visitor1;

public interface Visitor {
	public void visit(Engine engine);
	public void visit(Wheel wheel);
	public void visit(Steering steering);
}