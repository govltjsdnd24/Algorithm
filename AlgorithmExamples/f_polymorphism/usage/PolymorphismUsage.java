package com.ssafy.f_polymorphism.usage;

import com.ssafy.d_inheritance.person.Person;
import com.ssafy.d_inheritance.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // TODO:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.
    	Object [] objs= new Object[5];
    	objs[0]= "Hello";
    	objs[1]= objs;
    	objs[2]= new Object();
    	objs[3]= Integer.valueOf(3);
    	objs[4]=1; //1 --> Integer
    	
    	for (Object obj:objs) {
    		System.out.println(obj+" :"+obj.getClass().getName());
    	}
        // END
    }

    public void useObjectParam() {
        System.out.println(1);
        System.out.println("Hello");
        System.out.println(new Person("피터파커"));
        System.out.println(new SpiderMan("피터파카",true));
    }

    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        //usage.useObjectArray();
        usage.useObjectParam();
        //usage.polyTest();
    }
    
    public void polyTest() {
    	SpiderMan sman= new SpiderMan("피터",true);
    	Person p = sman; //still has spiderman's methods and values
    	p.eat();
    	if (p instanceof SpiderMan){
	    	SpiderMan sman2= (SpiderMan)p;
	    	sman.fireWeb();
    	}
    	Object o = sman;
    	
    	Person p2= new Person("홍길동"); //starting from scratch
    	if (p2 instanceof SpiderMan){
    		SpiderMan sman3 =(SpiderMan)p2;
        	sman.fireWeb();
    	}
    	
    }
}
