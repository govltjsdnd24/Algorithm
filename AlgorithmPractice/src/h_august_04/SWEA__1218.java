package h_august_04;

import java.util.Stack;
import java.util.Scanner;

public class SWEA__1218 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,len;
		int i;
		boolean checker;
		char bracket,close_br;
		String line;
		
		for (test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stack= new Stack<Character>();
			checker=true;
			
			len=scan.nextInt();
			line=scan.next();
			
			if(len%2==1) {
				System.out.println("#"+test_case+" 0");
				continue;
			}
			
			
			for(i=0;i<len;i++) {
				bracket=line.charAt(i);
				if(bracket=='{' || bracket=='[' || bracket=='(' || bracket=='<')
					stack.push(bracket);
				else
				{
					close_br=stack.pop();
					if((bracket=='}' && close_br!='{') || (bracket==']' && close_br!='[') || (bracket==')' && close_br!='(') || (bracket=='>' && close_br!='<')) {
						checker=false;
						break;
					}
						
				}

			}
			
			if(checker==false || !stack.isEmpty())
				System.out.println("#"+test_case+" 0");
			
			else 
				System.out.println("#"+test_case+" 1");
		}
	}
}
