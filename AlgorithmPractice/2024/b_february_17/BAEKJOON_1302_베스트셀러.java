package b_february_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BAEKJOON_1302_베스트셀러 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        Map<String,Integer> wordMap=new HashMap<String,Integer>();
        for(int i=0;i<n;i++) {
        	String word=br.readLine();
        	if(wordMap.containsKey(word)) {
        		wordMap.put(word, wordMap.get(word)+1);
        	}
        	else {
        		wordMap.put(word, 0);
        	}
        }
        
        int max=0;
        String maxStr="";
        for(String word:wordMap.keySet()) {
        	if(wordMap.get(word)>max)
        		maxStr=word;
        }
        
        System.out.println(maxStr);

	}

}
