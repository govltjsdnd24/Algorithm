package com.ssafy.g_interface.inter.relation;

public class RelationShipTest {
    public static void main(String[] args) {
        Object[] objs = { new HandPhone(), new Camera(), new Phone(), new DigitalCamera() };

        // TODO: 충전 가능한 객체들을 충전하시오.
        Chargeable[] chargeables= {new HandPhone(), new DigitalCamera()};
        for (Chargeable c: chargeables) {
        	c.charge();
        }
        
        for(Object obj: objs) {
        	if(obj instanceof Chargeable) {
        		Chargeable chargeable = (Chargeable) obj;
        		chargeable.charge();
        	}
        }

        // END
    }

}
