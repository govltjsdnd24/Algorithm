package a_january_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEKJOON_7785_회사에있는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Map<String, String>map=new HashMap<String, String>();
		
		for(int tc=1;tc<=N;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		PriorityQueue<String>pQueue=new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return -1*o1.compareTo(o2);
			}
		});
		for(Map.Entry<String, String> entry:map.entrySet()) {
			if(entry.getValue().equals("enter"))
				pQueue.add(entry.getKey());
		}
		
		for(String name:pQueue)
			System.out.println(name);
		
	}

}
