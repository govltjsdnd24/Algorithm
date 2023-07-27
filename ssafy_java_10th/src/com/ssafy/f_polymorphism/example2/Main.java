package com.ssafy.f_polymorphism.example2;

public class Main {
	public static void main(String[] args) {
		PhoneStore s=new PhoneStore();
		Phone p = s.getPhone("apple","jbl");
		p.call();
		p.playMusic();
	}

}
