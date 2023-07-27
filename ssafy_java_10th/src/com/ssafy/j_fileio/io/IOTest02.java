package com.ssafy.j_fileio.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest02 {

	public static void main(String[] args) {
		try (FileReader fr= new FileReader("hello.txt");) {
			char c;
			while((c=(char)fr.read())!=-1) {
				fr.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
