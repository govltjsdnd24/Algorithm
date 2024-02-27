package com.ssafy.i_collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
//    List<String> friends = new ArrayList<>();
	static List<String> friends = new ArrayList<>();
	
    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest() {
        // TODO: friends에 여러명의 친구를 등록해보자.
    	friends.add("홍길동");
    	friends.add("홍길동"); //중복 데이터
    	friends.add("장길산");
    	friends.add(1,"임꺽정");
    	friends.add("이몽룡");
        // END
        System.out.println("추가 후 내용 출력: " + friends.toString());
    }

    public void retrieveTest() {
        // TODO: 다양한 조회 기능을 사용해보자.
        //  혹시 비어있지는 않나? 요소의 개수는 ?
    	System.out.println("empty?: "+friends.isEmpty());
    	System.out.println("size :"+friends.size());
        //  반복을 이용한 요소 순회
    	for(int i=0;i<friends.size();i++) {
    		System.out.println(i+" : "+friends.get(i));
    	}
    	
    	for(String str: friends) {
    		System.out.println(str);
    	}
        //  홍길동이 있다면 그 위치 출력
    	System.out.println(friends.indexOf("홍길동"));
    	System.out.println(friends.indexOf("홍길순"));
        // END
    	
    	
//    	Iterator<String> iter= friends.iterator();
//    	while(iter.hasNext()) {
//    		System.out.println(iter.next());
//    	}
    }
    
    

    public void updateTest() {
        // TODO: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
    	int idx = friends.indexOf("홍길동");
    	if(idx>=0) {
    		friends.set(idx, "율도국왕");
    	}
        // END
    	System.out.println("수정 후: "+friends);
    	
//    	for (int i = 0; i < friends.size(); i++) {
//			if(friends.get(i).equals("홍길동")) {
//				friends.set(i, "홍길동");
//			}
//		}
    }

    public void deleteTest() {
        // TODO: 0번째 친구와 율도국 왕을 삭제하시오.
    	for (int i = 0; i < friends.size(); i++) {
			if(i==0 || friends.get(i).contentEquals("율도국")) {
				 friends.remove(i--);
			}
		}
    	
    	//friends.remove(0);
    	friends.remove("율도국왕");
        // END
        System.out.println("삭제 후 : " + friends);
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
    }
}
