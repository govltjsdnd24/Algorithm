package l_december_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BAEKJOON_17219_비밀번호만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Map<String, String>map=new HashMap<String, String>();
		for(int tc=1;tc<=N;tc++) {
			st= new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=M;tc++) {
			sb.append(map.get(br.readLine())+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}

}
