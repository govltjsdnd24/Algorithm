package com.ssafy.c_abstraction.person;

public class Person {
	//속성 - 멤버 변수
	String name;
	int age;
	boolean isHungry;
	

	
	public Person(String name, int age, boolean isHungry) {
		this.name=name;
		this.age=age;
		this.isHungry=isHungry;
	}
	
	public Person(String name, int age) {
		this(name,age,false);
	}
	
	public Person(String name) {
		this(name,0,false);
	}
	public Person() {
		this("",0,false);
	}
	
	
	
	//동작
	void eat() {
		System.out.println("냠냠.");
		isHungry=false;
	};
	
	void work() {
		System.out.println("열심히");
		isHungry=true;
	};
	
	void printInfo() {
		System.out.println(name+" : "+age);
	}
}
