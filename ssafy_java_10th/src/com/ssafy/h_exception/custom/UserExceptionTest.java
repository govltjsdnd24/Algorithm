package com.ssafy.h_exception.custom;

import java.io.IOException;

public class UserExceptionTest {
    private static String[] fruits = { "사과", "오렌지", "토마토" };

    public static void main(String[] args) {
        boolean result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        // TODO: 2. getFruit2를 이용해서 오렌지 2개를 소비해서 예외 상황을 테스트 하시오.
        try {
        	getFruit2("오렌지");
        	getFruit2("오렌지");
        } catch(FruitNotFoundException e) {
        	System.out.println(e.getMessage());
        }

        // END

        // TODO: 4. 수박, 멜론, 복숭아을 저장해서 예외 상황을 테스트 하시오.
        setFruit("수박");
        try {
        	setFruit("멜론");
        	setFruit("복숭아");
        } catch(FruitFullException e) {
        	System.out.println(e.getMessage());
        }
    

    // END

    
    }
    public static boolean getFruit1(String name) {
    	for(int i=0;i<fruits.length;i++) {
    		if(fruits[i]!= null && fruits[i].equals(name)) {
    			fruits[i]=null;
    			return true;
    		}
    	}
    	return false;
    }
    
    // TODO: 1. getFruit1을 참조하여 예외를 활용하는 형태로 getFruit2를 작성하시오.
    public static void getFruit2(String name) throws FruitNotFoundException {
    	boolean present=getFruit1(name);
    	if(!present) throw new FruitNotFoundException(name);
    }
    //END
    
    // TODO: 3. 배열의 null인 지점에 과일을 저장하도록 작성하시오.
    public static void setFruit(String name) throws  FruitFullException{
    	for(int i=0;i<fruits.length;i++) {
    		if(fruits[i]==null) {
    			fruits[i]=name;
    		}
    	}
    	throw new FruitFullException(name);

    }
    // END
}
