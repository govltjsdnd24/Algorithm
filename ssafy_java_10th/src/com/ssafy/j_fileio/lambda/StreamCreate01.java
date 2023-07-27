package com.ssafy.j_fileio.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamCreate01 {

	public static void main(String[] args) {
		// # Arrays
		{
			String[] strArray= {
					"java","C","SQL"
			};
			Stream<String> stream1 = Arrays.stream(strArray);
			Stream<String> stream2= Stream.of(strArray);
			stream1.forEach(a->System.out.print(a+" "));
			System.out.println();
		}
		// # Collections
		{
			List<String>list= Arrays.asList("java","C","SQL");
			Stream<String> stream= list.stream();
			stream.forEach(a->System.out.print(a+" "));
			System.out.println();
		}
		//Stream.generate with Functional Interface
		{
			Stream<Integer> stream = Stream.generate(()->new Random().nextInt(10)).limit(5);
			stream.forEach(a->System.out.print(a+" "));
			
		}
		

	}

}
