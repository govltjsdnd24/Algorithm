package a_january_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BAEKJOON_25192_인사성밝은곰곰이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Map<String,Boolean> map=new HashMap<String, Boolean>();
		int count=0;
		
		for(int tc=1;tc<=N;tc++) {
			String sentence=br.readLine();
			if(!sentence.equals("ENTER")) {
				if(map.get(sentence)==null) {
					map.put(sentence, false);
					count++;
				}
//				else if(map.get(sentence)==false) {
//					count++;
//				}
			}
		}
		
		System.out.println(count);
	}

}
