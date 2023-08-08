package im.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("test.txt"));
		
		Scanner scanner=new Scanner(System.in);
		

	}

}
