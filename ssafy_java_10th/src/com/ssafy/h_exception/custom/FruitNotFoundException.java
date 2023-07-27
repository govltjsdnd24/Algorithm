package com.ssafy.h_exception.custom;

public class FruitNotFoundException extends Exception{
	public FruitNotFoundException(String fruit) {
		super(fruit+"는 찾을 수 없었습니다.");
	}
}
