package im.example;

import java.io.FileInputStream;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		System.setIn(new FileInputStream("test.txt"));
		
		Scanner scanner=new Scanner(System.in);
		

	}

}
