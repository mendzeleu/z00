package org.leme.z00.apps.z00app.examples.oop.car;

public class Car {
	
	private String color;
	private String make;
	private String model;
	private int numberOfWheels=4;
	private int numberOfDoors=5;

	public Car() {
		color="unknown";
		make="abstract";
		model="none";
	}
	
	
	public Car(String color, String make, String model) {
		this.color = color;
		this.make = make;
		this.model = model;
		this.numberOfWheels=5;
		this.numberOfDoors=5;		
		
	}
	

	public Car(String color, String make, String model, int numberOfWheels, int numberOfDoors) {
		super();
		this.color = color;
		this.make = make;
		this.model = model;
		this.numberOfWheels = numberOfWheels;
		this.numberOfDoors = numberOfDoors;
	}



	public String getColor() {
		return color;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", make=" + make + ", model=" + model + ", numberOfWheels=" + numberOfWheels
				+ ", numberOfDoors=" + numberOfDoors + "]";
	}

	
	
}
