package org.leme.z00.components.domain.zoo.animal;

import org.leme.hibernate.base.entity.DbEntity;

public abstract class Animal extends DbEntity {

	protected String sound;

	public Animal() {
	}
	
	public void sing(){
		System.out.println((new StringBuilder())
				.append(this.getClass().getSimpleName())
				.append(" makes ")
				.append(sound)
				.toString());
	}
	
	public abstract void move();
	
	@Override
	public String toString() {
		return "Animal[name=" + this.getClass().getSimpleName() + "]";
	}

}
