package a_january_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BAEKJOON_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence;
		StringBuilder answer=new StringBuilder();
		
		Loop:
		while(true) {
			Stack<Character>stack=new Stack<Character>();
			sentence=br.readLine();
			if(sentence=="")
				break;
			
			
			for(int i=0;i<sentence.length();i++) {
				char letter=sentence.charAt(i);
				switch(letter) {
				case '(':
				case '[':
					stack.add(letter);
					break;
				case ')':
					if(stack.isEmpty() || stack.pop()!='(') {
						answer.append("no\n");
						continue Loop;
					}
				case ']':
					if(stack.isEmpty() || stack.pop()!='[') {
						answer.append("no\n");
						continue Loop;
					}
				case '.':
					if(!stack.isEmpty()) {
						answer.append("no\n");
						continue Loop;
					}
				}
			}
			answer.append("yes\n");
		}
		System.out.println(answer.toString());
	}

}
