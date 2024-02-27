package com.ssafy.d_inheritance.person;

public class SpiderMan extends Person{
	//'has a' relationship
	Spider spider= new Spider();
	
	boolean isSpider;
	
	public SpiderMan(String name, boolean isSpider) {
		super(name);
		this.isSpider=isSpider;
	}
	
	public void fireWeb() {
		if(this.isSpider) {
			spider.fireWeb();
		}
		else {
			System.out.println("평범한 척");
		}
	}
	
	//overriding
	@Override
	public void jump() {
		if(isSpider) {
			spider.jump();
		}else {
			super.jump();
		}
	}
	
	//overloading
	public void eat(int speed) {
		System.out.println("엄청난 속도로 ");
		this.eat();
	}
	
	@Override
	public String toString() {
		return super.toString()+" isSpider " +this.isSpider;
	}
	
}
