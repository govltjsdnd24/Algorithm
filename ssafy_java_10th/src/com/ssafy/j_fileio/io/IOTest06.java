package com.ssafy.j_fileio.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOTest06 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		List<Person> list = new ArrayList();
		
		list.add(new Person("둘리", 7));
		
		list.add(new Person("도우너",8));
		list.add(new Person("또치", 9));
		list.add(new Person("마이콜", 10));
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("persons.ser")));
		//for(Person person: list) {
			oos.writeObject(list);
		//}
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("persons.ser")));
		Person s=null;
//		while( (s=(Person)ois.readObject())!= null) {
//			System.out.println(s);
//		}
		List<Person> l= (List<Person>)ois.readObject();
		System.out.println(l);
		ois.close();
		
	}

}
