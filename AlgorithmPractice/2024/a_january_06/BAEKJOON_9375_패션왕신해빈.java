package a_january_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BAEKJOON_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		
		for (int tc=1;tc<=N;tc++) {
			int clothes=Integer.parseInt(br.readLine());
			Map<String,Integer>map=new HashMap<String, Integer>();
			
			for(int i=0;i<clothes;i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				st.nextToken();
				String cloth=st.nextToken();
				if(map.containsKey(cloth))
					map.put(cloth,map.get(cloth)+1);
				else
					map.put(cloth, 1);
			}
			int result=1;
			
			for(int i:map.values()) 
				result*=(i+1);
			
			System.out.println(result-1);
		}
	}

}
