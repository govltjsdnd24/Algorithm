package com.ssafy.f_polymorphism.example;

public class Cat extends Animal{
	//재정의
	@Override
	public void walk() {
		System.out.println("cat walk");
	}
	
	//확장
	public void bark() {
		System.out.println("cat meow");
	}

}
