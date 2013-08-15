package com.sanjeeb.pattern.factory;

public class ShapeFactory {
	public IShape getShape(int[] sides) {
		IShape shape = null;
		if(sides.length == 3) {
			shape = (new Triangle(sides));
		} 
		if(sides.length == 4) {
			shape = new Rectangle(sides);
		} 
		if (sides.length == 5) {
			shape = new Pentagon(sides);
		} 
		return shape;
	}
}