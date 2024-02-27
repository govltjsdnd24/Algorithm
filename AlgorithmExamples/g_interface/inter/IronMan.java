package com.ssafy.g_interface.inter;

public class IronMan implements Heroable{

	@Override
	public int fire() {
		System.out.println("탕");
		return 0;
	}
	
	@Override
	public void changeShape() {
		System.out.println("짠");
	}
	
	@Override
	public void upgrade() {
		System.out.println("짜잔");
	}
	
}
