package a_january_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BAEKJOON_2776_암기왕 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=N;tc++) {
			StringBuilder sb= new StringBuilder();
			
			Map<Integer, Boolean>map=new HashMap<Integer, Boolean>();
			int aSize=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<aSize;i++) 
				map.put(Integer.parseInt(st.nextToken()), true);
			
			int bSize=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<bSize;i++) {
				if(map.containsKey(Integer.parseInt(st.nextToken())))
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			
			System.out.println(sb);
		}
	}

}
