package com.ssafy.f_polymorphism.example2;

public class ApplePhone implements Phone {
	private Speaker speaker;
	public ApplePhone(Speaker speaker) {
		this.speaker= speaker;
	}
	
	@Override
	public void call() {
		System.out.println("애플 폰이 전화를 겁니다");
	}

	@Override
	public void playMusic() {
		// TODO Auto-generated method stub
		speaker.music();
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub

	}

}
