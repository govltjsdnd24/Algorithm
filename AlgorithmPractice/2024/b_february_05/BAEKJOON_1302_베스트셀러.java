package b_february_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BAEKJOON_1302_베스트셀러 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Integer>map=new HashMap<String, Integer>();
		int n=Integer.parseInt(br.readLine());
		String word;
		
		for(int tc=1;tc<=n;tc++) {
			word=br.readLine();
			if(map.containsKey(word)) 
				map.put(word, map.get(word)+1);
			else
				map.put(word, 1);
		}
		
		String frequent=null;
		int max=0;
		for(String key: map.keySet()) {
			int occurence=map.get(key);
			if(occurence>max || (occurence==max && key.compareTo(frequent)<0)) {
				frequent=key;
				max=occurence;
			}
		}
		
		System.out.println(frequent);

	}

}
