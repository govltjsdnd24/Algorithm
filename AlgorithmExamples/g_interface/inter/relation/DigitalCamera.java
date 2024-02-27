package com.ssafy.g_interface.inter.relation;

// TODO: DigitalCamera를 충전 가능하게 설정하시오.
public class DigitalCamera extends Camera implements Chargeable{

	@Override
	public void charge() {
		System.out.println("디카충전");
		
	}
    // TODO: Chargeable을 구현하시오.

    // END
}
