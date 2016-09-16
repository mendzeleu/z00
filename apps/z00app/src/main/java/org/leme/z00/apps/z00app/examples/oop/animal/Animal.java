package org.leme.z00.apps.z00app.examples.oop.animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
	
	protected List<Leg> legs;

	protected Animal(int numberOfLegs) {
		initializeLegs(numberOfLegs);		
	}
	
	private Animal() {	
	}

	protected void initializeLegs(int numberOfLegs) {
		legs = new ArrayList<Leg>(numberOfLegs);
		for(int i = 0 ; i < numberOfLegs ; i++){
			legs.add(new Leg());
		}
	}
	

	public abstract int move(int meters);
}
