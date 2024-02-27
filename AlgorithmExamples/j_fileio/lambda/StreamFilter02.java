package com.ssafy.j_fileio.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFilter02 {

	public static void main(String[] args) {
		//distinct 중복해소
		{
			Stream<String> stream = Arrays.stream(new String[] {"a","b","c","a","b","e"});
			Stream<String> st = stream.distinct();
			st.forEach(a->System.out.println(a+" "));
		}
		System.out.println();
		//filtering
		{
			IntStream limit= Arrays.stream(new int[] {1,2,3,4,5});
			
			
		}
	}
	
}
