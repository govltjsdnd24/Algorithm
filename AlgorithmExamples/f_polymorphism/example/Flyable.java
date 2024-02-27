package com.ssafy.f_polymorphism.example;

public interface Flyable {
	public default void jump() {
		System.out.println("폴짝");
	}
	public void fly();
}
