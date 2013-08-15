package com.sanjeeb.pattern.factory;

public class Driver {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		IShape triangle = shapeFactory.getShape(new int[]{3,4,5});
		IShape square = shapeFactory.getShape(new int[]{3,4,5,6});
		IShape pentagon = shapeFactory.getShape(new int[]{3,4,5,6,7});
		System.out.println(triangle.getPerimeter());
		System.out.println(square.getPerimeter());
		System.out.println(pentagon.getPerimeter());
	}
}