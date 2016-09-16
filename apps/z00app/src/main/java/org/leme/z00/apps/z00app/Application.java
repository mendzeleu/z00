package org.leme.z00.apps.z00app;

import org.leme.z00.components.domain.zoo.Zoo;
import org.leme.z00.components.domain.zoo.ZooException;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String [] arg) throws ZooException{
		System.out.println( "Hello Welcome to Z00" );
		Zoo zoo = new Zoo();
		zoo.StartDay();
	}

}
