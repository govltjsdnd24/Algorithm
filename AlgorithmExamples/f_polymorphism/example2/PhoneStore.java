package com.ssafy.f_polymorphism.example2;

public class PhoneStore {
	public PhoneStore() {}
	public Phone getPhone(String name, String speaker) {
		if(name.equals("samsung"))
			if(speaker.equalsIgnoreCase("jbl")) {
				return new SamsungPhone(new JBL());
			}
			else
				return new SamsungPhone(new Harman());
		else
			if(speaker.equalsIgnoreCase("jbl")) {
				return new ApplePhone(new JBL());
			}
			else
				return new ApplePhone(new Harman());
	}
}
