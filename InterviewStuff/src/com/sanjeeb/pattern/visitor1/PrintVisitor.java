package com.sanjeeb.pattern.visitor1;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Engine engine) {
		System.out.println("Part name is " + engine.getPartName());
	}

	@Override
	public void visit(Wheel wheel) {
		System.out.println("Part name is " + wheel.getPartName());
	}

	@Override
	public void visit(Steering steering) {
		System.out.println("Part name is " + steering.getPartName());
	}
}
