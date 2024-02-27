package com.ssafy.j_fileio.io;

import java.io.Serializable;

class Person implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7394011543817117137L;
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}