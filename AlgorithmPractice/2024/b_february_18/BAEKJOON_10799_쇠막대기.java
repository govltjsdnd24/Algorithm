package b_february_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Stick{
	private int start;
	private int end;
	private int pieces=1;
	
	public Stick(int start){
		this.start=start;
	}
	public void setEnd(int end) {
		this.end=end;
	}
	public void increasePieces() {
		this.pieces++;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public int getPieces() {
		return pieces;
	}
	
	@Override
	public String toString() {
		return start+" : "+ end+ " : "+ pieces;
	}
}

public class BAEKJOON_10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String brackets=br.readLine();
		Stack<Stick>stack= new Stack<Stick>();
		List<Integer>lasers=new ArrayList<Integer>();
		List<Stick>sticks=new ArrayList<Stick>();
		
		int i;
		for(i=0;i<brackets.length();i++) {
			if(brackets.charAt(i)=='(') {
				//laser
				if(brackets.charAt(i+1)==')') {
					lasers.add(i);
					i++;
					continue;
				}
				//else
				else {
					//put stick with starting point
					stack.add(new Stick(i));
				}
			}
			// if )
			else {
				Stick stick=stack.pop();
				stick.setEnd(i);
				sticks.add(stick);
			}
		}
		
		int j;
		for(i=0;i<lasers.size();i++) {
			for(j=0;j<sticks.size();j++) {
				if(lasers.get(i)>sticks.get(j).getStart() && lasers.get(i)<sticks.get(j).getEnd()) {
					sticks.get(j).increasePieces();
				}
			}
		}
		
		int pieces=0;
		for(j=0;j<sticks.size();j++) {
			pieces+=sticks.get(j).getPieces();
		}
		System.out.println(pieces);

	}

}
