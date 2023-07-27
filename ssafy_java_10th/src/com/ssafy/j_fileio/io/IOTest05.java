package com.ssafy.j_fileio.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//class Person implements Serializable{
//	private String name;
//	private int age;
//	public Person(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + "]";
//	}
//	
//}

public class IOTest05 {

	public static void main(String[] args) throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("data.ser");
		Person p = new Person("둘리",7);
		ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(fos));
		
		
		oos.writeObject(p);
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data.ser")));
		
		Person p1= (Person)ois.readObject();
		System.out.println(p1);
		
		ois.close();
		
	}

}
