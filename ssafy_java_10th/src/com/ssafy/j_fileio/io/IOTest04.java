package com.ssafy.j_fileio.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest04 {

	public static void main(String[] args) throws FileNotFoundException {
		try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("test01.txt")));){
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
