package com.ssafy.f_polymorphism.example2;

public class SamsungPhone implements Phone {
	private Speaker speaker;
	public SamsungPhone(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void call() {
		System.out.println("삼성폰이 전화를 겁니다");
	}

	@Override
	public void playMusic() {
		speaker.music();
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
	}
}
