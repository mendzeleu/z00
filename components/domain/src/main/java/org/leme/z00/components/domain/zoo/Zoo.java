package org.leme.z00.components.domain.zoo;

import java.util.ArrayList;
import java.util.List;

import org.leme.z00.components.domain.zoo.animal.Animal;
import org.leme.z00.components.domain.zoo.animal.impl.Bear;
import org.leme.z00.components.domain.zoo.animal.impl.Eagle;
import org.leme.z00.components.domain.zoo.animal.impl.Hawk;
import org.leme.z00.components.domain.zoo.animal.impl.Lion;
import org.leme.z00.components.domain.zoo.animal.impl.Owl;
import org.leme.z00.components.domain.zoo.animal.impl.Rabbit;

public class Zoo {
	
	List<Shelter> shelters;
	List<Animal> animals;

	public Zoo() throws ZooException {
		shelters = new ArrayList<>();
		for(int i = 0 ; i < 7; i++){
			shelters.add(new Shelter(String.valueOf(i)));
		}

		animals = new ArrayList<>();
		animals.add(new Lion());
		animals.add(new Bear());
		animals.add(new Rabbit());			
		animals.add(new Owl());
		animals.add(new Hawk());
		animals.add(new Eagle());
	}

	
	public void StartDay() throws ZooException{
		for(int i  = 0 ; i < animals.size(); i++ ){
			shelters.get(i).setAnimal(animals.get(i));
		}	
		System.out.println("********************* Shelters State ********************* ");
		System.out.println(shelters);			
		System.out.println(" *************** SINGING *****************");		
		sing();		
		for(int i  = 0 ; i < shelters.size(); i++ ){
			System.out.println(" *************** ROTATING " + i + " *****************");
			rotate();
			System.out.println(" *************** SINGING  " + i + " *****************");
			sing();			
		}
		System.out.println("********************* Shelters Satete ********************* ");
		System.out.println(shelters);					
	}
	
	private void sing(){
		for(int i  = 0 ; i < animals.size(); i++ ){
			animals.get(i).sing();
		} 
	}

    private int findEmpty() throws ZooException{
        for(int i  = 0 ; i < shelters.size(); i++ ){
            if(shelters.get(i).isEmpty()){
             return i;
            }
        }
        throw new ZooException("There is no empty shelter found");
    }
	
	private void rotate() throws ZooException{
        int emptyShelterIndex = findEmpty();

		for(int i = emptyShelterIndex+1; i<shelters.size(); i++){
			doOneMove(shelters.get(i), shelters.get(i-1));
		}
		
		for(int i = 0 ; i< emptyShelterIndex; i++){
            Shelter to = i==0 ? shelters.get(shelters.size()-1) : shelters.get(i-1);
            Shelter from = i==0 ? shelters.get(i) : shelters.get(i);
			doOneMove(from, to);
		}
	}

	private void doOneMove(Shelter from, Shelter to) throws ZooException {
		Animal animalToMove = from.removeAnimal();
		if(animalToMove != null){
            System.out.print("From Shelter "+ from.getName()+" " +animalToMove);
            animalToMove.move();
            System.out.println("to Shelter "+to.getName());
            to.setAnimal(animalToMove);
        }
	}


}
