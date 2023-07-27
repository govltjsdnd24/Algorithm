package com.ssafy.d_inheritance.person;

public class Person {
	String name;
	
	public Person(String name) {
		this.name=name;
	}
	
	public void eat() {
		System.out.println("냠냠");
	}
	public void jump() {
		System.out.println("폴짝");
	}
	
	@Deprecated
	void 주접떨기() {
		System.out.println("주저리");
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
