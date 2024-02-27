package com.ssafy.f_polymorphism.example;

public class Bird extends Animal implements Flyable{

	@Override
	public void walk() {
		System.out.println("bird walk");
		
	}
	
	public void fly() {
		System.out.println("bird flight");
	}
	
}
