package com.ssafy.e_modifier.encapsulation;

class UnbelievableUserInfo {
    // 이름은 null이 될 수 없음.
    private String name = "홍길동";
    // 계좌는 0보다 커야 함.

    private int account = 10000;
    
    public UnbelievableUserInfo() {
    	this("default",0);
    }
	public UnbelievableUserInfo(String name, int account) {
		super();
		this.name = name;
		this.account = account;
	}
    // TODO: name 과 account에 부적절한 값이 할당되지 못하도록 처리하시오.
    //  name과 account 는 private으로 변경되어야 한다.
    public void setName(String name) {
    	//데이터 보호 로직 추가
    	if(name==null) {
    		System.out.println("name can't have a null value");
    		return;
    	}
    	this.name=name;
    }
    public String getName() {
    	return this.name;
    }
  
	public void setAccount(int account) {
		if(account<0) {
			System.out.println("account can't go below 0");
			return;
		}
		this.account = account;
	}
	public int getAccount() {
		return account;
	}
}

public class UnbelievableTest {
    public static void main(String[] args) {
        UnbelievableUserInfo info = new UnbelievableUserInfo();
        System.out.printf("사용자 정보:%s, %d%n", info.getName(),info.getAccount());
        //
        info.setName(null);
        info.setAccount(-1000);
        System.out.printf("사용자 정보:%s, %d%n", info.getName(),info.getAccount());
    }
}
