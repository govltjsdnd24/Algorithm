package a_january_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BAEKJOON_1927_최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>();
		int tc;
		int in;
		for(tc=1;tc<=N;tc++) {
			in=Integer.parseInt(br.readLine());
			if(in!=0)
				maxHeap.add(in);
			else {
				if(maxHeap.isEmpty())
					System.out.println(0);
				else
					System.out.println(maxHeap.poll());
			}	
		}

	}

}
