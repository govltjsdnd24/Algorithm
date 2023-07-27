package com.ssafy.g_interface.inter.staticdefault;

import java.util.Arrays;

interface Aircon {
    void makeCool();

    // TODO: 2. 건조기능을 추가해보자.
    default void dry() {
    	System.out.println("사실은 모두 건조 필요");
    };
    // END
    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void desc() {
    	System.out.println("에어컨이란 공기를 시원하게 한다.");
    }
    // END

}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NoWindAircon implements Aircon{
	@Override
	public void makeCool() {
		System.out.println("바람 없이도 시원");
	}
	
	@Override
	public void dry() {
		System.out.println("종료하면 자동으로 건조해줄께");
	}
}
// END

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { new OldisButGoodies1(), new OldisButGoodies2() };
        for (Aircon aircon : aircons) {
            aircon.makeCool();
        }
    }
}
