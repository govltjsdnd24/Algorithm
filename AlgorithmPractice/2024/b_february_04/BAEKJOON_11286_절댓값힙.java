package b_february_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Absolute implements Comparable<Absolute> {
	long original;
	long absolute;
	
	public Absolute(long original) {
		this.original = original;
		this.absolute = Math.abs(original);
	}

	@Override
	public int compareTo(Absolute o) {
		if(this.absolute!=o.absolute)
		return Long.compare(this.absolute, o.absolute);
		else 
			return Long.compare(this.original, o.original);
	}
	
	@Override
	public String toString() {
		return this.original+" "+this.absolute;
	}
	
	
}

public class BAEKJOON_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Absolute> pQueue=new PriorityQueue<Absolute>();
		long in; 
		
		for(int tc=1;tc<=N;tc++) {
			in=Long.parseLong(br.readLine());
			if(in!=0)
				pQueue.add(new Absolute(in));
			else {
				if(pQueue.isEmpty())
					System.out.println(0);
				else
					System.out.println(pQueue.poll().original);
			}
		}
	}
}
