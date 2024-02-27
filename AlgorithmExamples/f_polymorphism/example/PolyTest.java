package com.ssafy.f_polymorphism.example;

interface II{}
interface IA extends II{}
interface IB{}
class A implements IA{}
class B extends A implements IB{}

public class PolyTest {

	public static void main(String[] args) {
		
		B b = new B();
		print1(b);
	}
	static void print1(II i) {
		print2((IB)i);
	}
	static void print2(IB b) {
		
	}

}
