package b_february_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BAEKJOON_10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String brackets=br.readLine();
		Stack<Character>stack= new Stack<Character>();
		List<Integer>lasers=new ArrayList<Integer>();
		
		for(int i=0;i<brackets.length();i++) {
			if(brackets.charAt(i)=='(') {
				//laser
				if(brackets.charAt(i+1)==')') {
					lasers.add(i);
					i++;
					continue;
				}
				//else
				else {
					
				}
			}
		}

	}

}
