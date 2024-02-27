package com.ssafy.h_exception.custom;

import java.io.IOException;

public class FruitNotFoundException extends RuntimeException{
	public FruitNotFoundException(String fruit) {
		super(fruit+"는 찾을 수 없었습니다.");
	}
}
