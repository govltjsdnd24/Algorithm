package com.ssafy.h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
    	try {
        Class.forName("abc.Def"); // ClassNotFoundException
        new FileInputStream("Hello.java"); // FileNotFoundException
        DriverManager.getConnection("Hello"); // SQLException
    	} catch(ClassNotFoundException e){
    		System.out.println("사용하려는 클래스가 없습니다.");
    	} catch(FileNotFoundException e) {
    		System.out.println("읽으려는 파일이 없습니다.");
    	}
    	catch(SQLException e) {
    		System.out.println("DB 접속 확인 plz");
    	}
    	
        // END
        System.out.println("프로그램 정상 종료");

    }
}
