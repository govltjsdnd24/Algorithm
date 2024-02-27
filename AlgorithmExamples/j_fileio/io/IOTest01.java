package com.ssafy.j_fileio.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f= new File("hello.txt");
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
				OutputStreamWriter osw = new OutputStreamWriter(bos)
			){
			osw.write("Hello");
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일 쓰기 완료");
	}

}
