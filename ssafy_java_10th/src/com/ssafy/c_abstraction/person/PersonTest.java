package com.ssafy.c_abstraction.person;

public class PersonTest {

	public static void main(String[] args) {
		Person person1= new Person();
		person1.name="홍길동";
		person1.isHungry=true;
		person1.eat();
		person1.work();
		
		
		Person person2=new Person("장길산",12,true);
		System.out.println(person1.name+" : "+person1.isHungry);
		System.out.println(person2.name+" : "+person2.isHungry);
		System.out.println(person1.name+" : "+person1.isHungry);
		System.out.println(person1.name+" : "+person1.isHungry);

		person1.printInfo();
		person2.printInfo();
	}

}
