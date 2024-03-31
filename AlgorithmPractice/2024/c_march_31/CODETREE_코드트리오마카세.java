package c_march_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Customer{
	String name;
	int count;
	
	public Customer(String name, int count) {
		this.name=name;
		this.count=count;
	}
}

public class CODETREE_코드트리오마카세 {
	
	@SuppressWarnings("unchecked")
	static Map<Integer,List<String>>belt;
	static Customer[] customers;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int L=Integer.parseInt(st.nextToken()); //sushi belt length
		int Q=Integer.parseInt(st.nextToken()); //number of commands
		
		belt=new HashMap<Integer,List<String>>();
		customers=new Customer[L];
		int spinOffset=0;
		int currTime=0;
		for(int q=0;q<Q;q++) {
			st =new StringTokenizer(br.readLine());
			//type of input
			int input=Integer.parseInt(st.nextToken());
			//move belt based on time
			currTime=Integer.parseInt(st.nextToken());
			spinOffset=(spinOffset+currTime)%L;
			//command execute
			int place=0;
			switch(input) {
			//put sushi
			case 100:
				place=Integer.parseInt(st.nextToken())-1+spinOffset;
				if(belt.get(place)==null){
					belt.put(place,new ArrayList<String>());
				}
				List<String>temp=belt.get(place);
				temp.add(st.nextToken());
				belt.put(place, temp);
				break;
			//customer enters
			case 200:
				place=Integer.parseInt(st.nextToken())-1;
				customers[place]=new Customer(st.nextToken(),Integer.parseInt(st.nextToken()));
				break;
			case 300:
				
			}
		}
		
	}

}
