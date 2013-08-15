package com.sanjeeb.pattern.visitor1;

import java.util.LinkedList;
import java.util.List;

public class Car implements CarElement {
	List<CarElement> list;
	
	public Car() {
		Wheel wheel1 = new Wheel("Front Left wheel");
		Wheel wheel2 = new Wheel("Front Right wheel");
		Wheel wheel3 = new Wheel("Rear Left wheel");
		Wheel wheel4 = new Wheel("Rear Right wheel");
		Engine engine = new Engine("Engine");
		Steering steering = new Steering("Engine");
		
		list = new LinkedList<>();
		list.add(wheel1);
		list.add(wheel2);
		list.add(wheel3);
		list.add(wheel4);
		list.add(engine);
		list.add(steering);
	}
	
	@Override
	public void accept(Visitor visitor) {
		for(CarElement element : list) 
			element.accept(visitor);
	}
}