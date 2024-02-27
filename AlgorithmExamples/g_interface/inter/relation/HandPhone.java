package com.ssafy.g_interface.inter.relation;

// TODO: HandPhone를 충전 가능하게 설정하시오.
public class HandPhone extends Phone implements Chargeable{

	@Override
	public void charge() {
		// TODO Auto-generated method stub
		System.out.println("핸드폰충전");
	}
    // TODO: Chargeable을 구현하시오.

    // END
}
