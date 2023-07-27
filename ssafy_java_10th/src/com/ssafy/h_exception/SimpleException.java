package com.ssafy.h_exception;

public class SimpleException {
    public static void main(String[] args) {
        int[] intArray = { 10 };
        try {
        	System.out.println(intArray[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println("out of bounds!"+e.getMessage());
        	e.printStackTrace();
        }
        System.out.println("프로그램 종료합니다.");
    }
}
