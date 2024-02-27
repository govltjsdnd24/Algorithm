package b_february_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class BAEKJOON_10815_숫자카드 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int M= Integer.parseInt(br.readLine());
		//int[] in_arr=new int[M];
		Map<Integer,Integer> in_map= new HashMap<Integer,Integer>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			//in_arr[i]=Integer.parseInt(st.nextToken());
			in_map.put(Integer.parseInt(st.nextToken()), 0);
		}
		int N= Integer.parseInt(br.readLine());
		int[] comp_arr=new int[N];
		//Map<Integer, Integer> comp_map= new HashMap<Integer,Integer>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			comp_arr[i]=Integer.parseInt(st.nextToken());
			//comp_map.put(i, Integer.parseInt(st.nextToken()));
		}
		
		String answers=compare_array(in_map, comp_arr);
		System.out.println(answers);
	}
 
	public static String compare_array( Map<Integer,Integer> in_map, int[]comp_arr) {
		StringBuilder sb=new StringBuilder();
		
		for(int j=0;j<comp_arr.length;j++) {
			if(in_map.get(comp_arr[j])!=null) {
				sb.append("1 ");
			}
			else
				sb.append("0 ");
		}
		
		String answers=sb.toString();
		return answers;
	}
 
}
