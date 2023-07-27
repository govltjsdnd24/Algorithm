package com.ssafy.j_fileio.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda03 {
	
	private static Integer[] numbs= {3,5,6,2,1,4};

	public static void main(String[] args) {
		Arrays.sort(numbs, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		System.out.println(Arrays.toString(numbs));
		
		Arrays.sort(numbs, (o1,o2)->Integer.compare(o2, o1));
		System.out.println(Arrays.toString(numbs));

	}

}
