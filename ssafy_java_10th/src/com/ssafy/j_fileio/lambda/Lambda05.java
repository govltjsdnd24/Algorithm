package com.ssafy.j_fileio.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Lambda05 {
	private Map<String, Integer>jumsu;
	public Lambda05() {
		 jumsu= new HashMap<String, Integer>();
		 jumsu.put("둘리",100);
		 jumsu.put("도우너",80);
		 jumsu.put("또치",90);
		 jumsu.put("마이콜",50);
		 
	}
	
	public static void main(String[] args) {
		Lambda05 lam= new Lambda05();
		lam.consumerTest();
		lam.supplierTest();
		lam.functionTest();
		lam.predicateTest();

	}
	private void consumerTest() {
		jumsu.forEach((name,score)-> System.out.println(name+" , "+score));
	}
	
	private void supplierTest() {
		Integer res = jumsu.get("고길동");
		System.out.println(res);
		//만약 res가 null이면 0 ~100 사이의 값을 자동으로 구하게 프로그래밍 해보세요
		Integer score = Optional.ofNullable(res).orElseGet(()->new Random().nextInt(100));
		System.out.println(score);
	}
	
	private void functionTest() {
		List<String>list= jumsu.entrySet()
				.stream()
				.map(e->String.format("%s(%d)",
						e.getKey(), e.getValue())).collect(Collectors.toList());
	System.out.println(list);
	}
	private void predicateTest() {
		jumsu.entrySet()
		.stream()
		.filter(entry->entry.getKey().length()>3 && entry.getValue()>=90).collect(Collectors.toSet());
	}
}
