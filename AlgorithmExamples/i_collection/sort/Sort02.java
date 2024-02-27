package com.ssafy.i_collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person>{
	int age;
	int weight;
	String name;
	public Person(int age, int weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
	
	public int compareTo(Person o) {
		return Integer.compare(this.age, o.age);
	}
	
}

public class Sort02 {

	public static void main(String[] args) {
	 	Person[] arr= new Person[] { 
	 			new Person("둘리",7,10),
	 			new Person("도우너",8,13),
	 			new Person("또치",6,7),
	 			new Person ("마이콜",8,17)
	 	};

	 	Arrays.sort(arr, new Comparator<Person>() {
	 		@Override
	 		
	 		public int compare(Person o1,Person o2) {
	 			if(o1.age==o2.age) {
	 				return Integer.compare(o1.weight, o2.weight);
	 			}
	 			return Integer.compare(o1.age, o2.age);
	 		}
	 	});
	 	System.out.println(Arrays.deepToString(arr));
	 	
	 	List<Person> list= Arrays.asList(arr);
	 	
	 	Collections.sort(list, new Comparator<Person>() {
	 		@Override
	 		public int compare(Person o1,Person o2) {
	 			if(o1.age==o2.age) {
	 				return Integer.compare(o1.weight, o2.weight);
	 			}
	 			return Integer.compare(o1.age, o2.age);
	 		}
	 	});
	 	System.out.println(list);
	 	
	 	Collections.sort(list, new Comparator() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.age, o2.age)*-1;
				return 0;
			}});
	 	
	 	
	}

}
