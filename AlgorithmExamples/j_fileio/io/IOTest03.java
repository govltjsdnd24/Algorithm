package com.ssafy.j_fileio.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class IOTest03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		FileOutputStream fos= new FileOutputStream("test01.txt");
		BufferedOutputStream bos= new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeInt(22);
		dos.writeUTF("Hello");
		dos.writeFloat(3.4f);
		
		
		dos.close();

	}

}
