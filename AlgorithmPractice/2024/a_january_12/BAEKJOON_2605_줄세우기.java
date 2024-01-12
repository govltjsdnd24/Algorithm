package a_january_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Line implements Comparable<Line>{
	int number;
	int movement;
	
	public Line(int number,int movement) {
		this.number=number;
		this.movement=movement;
	}
	
	@Override
	public int compareTo(Line o) {
		return  Integer.compare(this.number-movement, o.number-o.movement);
	}
	
	@Override
	public String toString() {
		return number+"";
	}

}

public class BAEKJOON_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Line> pQueue= new PriorityQueue<Line>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int tc=1;tc<=N;tc++) {
			pQueue.add(new Line(tc,Integer.parseInt(st.nextToken())));
		}
		
		for(int tc=1;tc<=N;tc++) {
			System.out.print(pQueue.poll()+" ");
		}
	}

}
