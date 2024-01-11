package a_january_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Candidate implements Comparable<Candidate>{
	int number;
	int votes;
	
	public Candidate(int number,int votes) {
		this.number=number;
		this.votes=votes;
	}
	
	@Override
	public int compareTo(Candidate o) {
		if(this.votes==o.votes) {
			return Integer.compare(this.number, o.number);
		}
		else
			return -1 * Integer.compare(this.votes, o.votes);
	}
	
	
}

public class BAEKJOON_1417_국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Candidate> pQueue=new PriorityQueue<Candidate>();
		
		for(int tc=1;tc<=N;tc++) {
			pQueue.add(new Candidate(tc, Integer.parseInt(br.readLine())));
		}
		int count=0;
		while(pQueue.peek().number!=1) {
			Candidate top=pQueue.poll();
			top.votes--;
			pQueue.add(top);
			count++;
		}
		
		System.out.println(count==0?1:count/2);

	}

}
