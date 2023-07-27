package com.ssafy.f_polymorphism.example;

public class Main {

	public static void main(String[] args) {
//		Animal cannot be objectified
//		Animal animal = new Animal();
		Animal c = new Cat();
		Animal b = new Bird();
		Animal h = new Human();
		Animal s = new Superman();
		Dog d= new Dog();
		
		toWalk(c);
		toWalk(b);
		toWalk(h);
		toWalk(s);
		toWalk(d);
		
		
		toFly((Flyable)s);
		toFly((Flyable)b);
	}
	
	public static void toWalk(Animal a) {
		a.walk();
	}
	
	public static void toFly(Flyable f) {
		f.fly();
	}

}
