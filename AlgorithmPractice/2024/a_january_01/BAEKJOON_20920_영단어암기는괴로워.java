package a_january_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vocabulary implements Comparable<Vocabulary>{
	String word;
	int frequency;
	int length;
	
	public Vocabulary(String vocab,int frequency) {
		this.word=vocab;
		this.frequency=frequency;
		this.length=vocab.length();
	}

	@Override
	public int compareTo(Vocabulary o) {
	    if (this.frequency != o.frequency) {
	        return -1*Integer.compare(this.frequency, o.frequency);
	    } 
	    else if (this.length != o.length) {
	        return -1*Integer.compare(this.length, o.length);
	    } 
	    else {
	        return this.word.compareTo(o.word);
	    }
	}
}

public class BAEKJOON_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		Map<String, Vocabulary>map=new HashMap<String, Vocabulary>();
		
		for(int tc=1;tc<=N;tc++) {
			String word=br.readLine();
			if(word.length()<M)
				continue;
			else if(map.containsKey(word)) {
				map.put(word, new Vocabulary(word,map.get(word).frequency+1));
			}
			else {
				map.put(word, new Vocabulary(word,1));
			}
		}
		
		PriorityQueue<Vocabulary>pQueue=new PriorityQueue<Vocabulary>();
		for(Map.Entry<String,Vocabulary>entry:map.entrySet()) {
			pQueue.add(entry.getValue());
		}
		
		StringBuilder sb= new StringBuilder();

		int size=pQueue.size();
		for(int i=0;i<size;i++)
			sb.append(pQueue.poll().word+"\n");
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}

}
