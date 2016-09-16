package org.leme.z00.apps.z00app.examples.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public class A {
		
		public void a1(){
			System.out.println("a1");
		}
		
	}
	
	public class B extends A {
		
		public void a1(){
			System.out.println("b1");
		}
		
		public void c1(){
			a1();
		}
	}
	
	public void m_main(){
		A t1 = new B();
		t1.a1();
	}
	
	public static void main(String[] args) {
	
		Main m = new Main();
		m.m_main();
	}

}
































//	Main.A b1 = new Main.B();
//	((Main.B)b1).c1();
//	b1.a1();

		
		
		
	
	
	
		// TODO Auto-generated method stub
		
//		List<ToString> l = new ArrayList<ToString>();
//		for(int i =0; i< l.size() ; i++){
//			System.out.println(l.get(i).toStringX());
//		}
//		
//		Car car = new Car("blue","mazda", "3");
//		
//		//Month.JANUARY.shortName = "";
//		// Month.JANUARY.shortName
//		
//		System.out.println(car);
//		
//		Month.JANUARY.getShortName();
		
//		ArrayList<Month> listM = new ArrayList<Month>();
//		listM.add(Month.JANUARY);
//		listM.add(Month.FEBRUARY);
//		listM.add(Month.JANUARY);
		
	
	
	
	
//	
//		ArrayList<Animal> list = new ArrayList<Animal>();
//		list.add(new Frog());
//		list.add(new Lion());
//		list.add(new Frog());
//		
//		for(int i = 0 ; i < list.size(); i++){
//			Animal a = list.get(i);
//			int passed = a.move(1);
//			if(a instanceof Lion){
//				System.out.println(((Lion)a).makeRRRRRRRRRR());
//			}
//			System.out.println(a.getClass().getSimpleName() + " passed meters: "+passed);
//		}

