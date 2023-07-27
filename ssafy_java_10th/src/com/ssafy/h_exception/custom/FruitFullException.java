package com.ssafy.h_exception.custom;

public class FruitFullException extends Exception{
	public FruitFullException(String fruit) {
		super(fruit+"은 공간이 부족하여 저장할 수 업습니다");
	}
}
