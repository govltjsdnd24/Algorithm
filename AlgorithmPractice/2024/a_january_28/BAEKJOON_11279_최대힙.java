package a_january_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BAEKJOON_11279_최대힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o1, o2) * -1;
					}
		});
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
