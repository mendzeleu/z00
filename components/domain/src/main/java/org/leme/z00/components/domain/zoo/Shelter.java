package org.leme.z00.components.domain.zoo;

import org.leme.z00.components.domain.zoo.animal.Animal;

public class Shelter {

	private Animal animal;
	private String name;

	public Shelter(String name) {
		this.name = name;
	}

	public void setAnimal(Animal animal) throws ZooException {
		if (!isEmpty()) {
			throw new ZooException("Shelter is not Empty");
		}
		this.animal = animal;
	}

	public Animal removeAnimal() {
		Animal tmpAnimal = this.animal;
		this.animal = null;
		return tmpAnimal;
	}

	public boolean isEmpty() {
		return animal == null;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Shelter [name=" + name + ", animal=" + animal + "]";
	}
	
}
