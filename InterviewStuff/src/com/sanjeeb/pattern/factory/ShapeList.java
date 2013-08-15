package com.sanjeeb.pattern.factory;

public class ShapeList {}

class Triangle implements IShape{
	final int[] sides;
	final int numberOfSides = 3;
	public Triangle(int[] sides) {
		this.sides = sides;
	}
	public int getPerimeter() {
		if(sides.length != numberOfSides) {
			throw new IllegalArgumentException("Triangle needs 3 sides");
		}
		int perimeter = 0;
		for(int i = 0; i < sides.length; ++i){
			perimeter+= sides[i];
		}
		return perimeter;
	}
}

class Rectangle implements IShape{
	final int numberOfSides = 4;
	final int[] sides;
	public Rectangle(int[] sides) {
		this.sides = sides;
	}
	public int getPerimeter() {
		if(sides.length != numberOfSides) {
			throw new IllegalArgumentException("Rectangle needs 4 sides");
		}
		int perimeter = 0;
		for(int i = 0; i < sides.length; ++i){
			perimeter+= sides[i];
		}
		return perimeter;
	}
}
class Pentagon implements IShape {
	final int numberOfSides = 5;
	final int[] sides;
	public Pentagon(int[] sides) {
		this.sides = sides;
	}
	public int getPerimeter() {
		if(sides.length != numberOfSides)
			throw new IllegalArgumentException("Pentagon needs 5 sides");
		
		int perimeter = 0;
		for(int i = 0; i < sides.length; ++i){
			perimeter+= sides[i];
		}
		return perimeter;
	}
}



