package c_march_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class BAEKJOON_1764_듣보잡 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Map<String, Boolean>map= new HashMap<String, Boolean>();
		
		for(int i=0;i<N;i++) {
			String name=br.readLine();
			map.put(name, false);
		}
		for(int j=0;j<M;j++) {
			String name=br.readLine();
			if(map.get(name)!=null) {
				map.put(name, true);
			}
		}
		
		int count=0;
		List<String> list=new ArrayList<String>();
		for(String key:map.keySet()) {
			if (map.get(key)) {
				count++;
				list.add(key);
			}
		}
		
		Collections.sort(list);
		System.out.println(count);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
 
 
}
