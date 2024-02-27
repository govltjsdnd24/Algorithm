package com.ssafy.g_interface.inter.module;

public class LaserPrinter implements Printer{

	@Override
	public void print(String fileName) {
		System.out.println("레이저로.."+fileName+"을 출력!");
	}
	
}
