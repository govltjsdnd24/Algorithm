package b_february_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BAEKJOON_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        
        //every iteration
        for(int tc=1; tc<=t;tc++) {
        	String brackets=br.readLine();
        	Stack<Character> stack=new Stack<Character>();
        	boolean answer=true;
        	
        	if(brackets.charAt(0)==')') {
        		System.out.println("NO");
        		continue;
        	}

        	for(int i=0;i<brackets.length();i++) {
        		char bracket=brackets.charAt(i);
        		if(bracket=='(')
        			stack.push(bracket);
        		else {
        			if(stack.isEmpty() || stack.peek()==')') {
        				answer=false;
        				break;
        			}
        			else if(stack.peek()=='(')
        				stack.pop();
        			
        			
        		}
        	}
        	if(!answer || !stack.isEmpty())
            	System.out.println("NO");
            else
            	System.out.println("YES");
        }
       
        
    }
}
