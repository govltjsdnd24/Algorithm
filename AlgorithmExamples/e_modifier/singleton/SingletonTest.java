package com.ssafy.e_modifier.singleton;

class SingletonClass {

	private static SingletonClass sc = new SingletonClass();
	public static SingletonClass getInstance() {
		return sc;
	}
	private SingletonClass() {
		System.out.println("100만원 추가요!!");
	}
	public void sayHello() {
		System.out.println("Hello");
	}
}

public class SingletonTest {
  public static void main(String[] args) {
    // TODO:SingletonClass를 사용해보세요.
	  SingletonClass sc = SingletonClass.getInstance();
	  sc.sayHello();
	  SingletonClass sc2 = SingletonClass.getInstance();
	  sc2.sayHello();
    // END
  }
}
