package com.ssafy.h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HierachyException {
	FileInputStream input=null;
	
	public HierachyException() throws FileNotFoundException{
		String src = "./.pfject";
        // TODO: 상속 관계를 고려하여 다음에서 예외를 처리해보자.

		input = new FileInputStream(src);

	}
	
	public void go() throws IOException{
		int readData = -1;
        while ((readData = input.read()) != -1) {
         System.out.print((char) readData);
        }
	 

		
	} 
	
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
    	try {
        HierachyException hi= new HierachyException();
        hi.go();
        // END
    	} catch(FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("something wrong with io");
			e.printStackTrace();
		}

        System.out.println("파일 읽음 완료!");
    }

}
