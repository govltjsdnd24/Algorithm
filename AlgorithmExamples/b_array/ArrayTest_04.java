package com.ssafy.b_array;

import java.util.Arrays;

public class ArrayTest_04 {
    public static void main(String[] args) {

        String org = "SSAFY";
        // TODO: char []을 이용해 String org의 각 문자를 저장하고 출력하는 코드를 작성하시오.
        char [] arr= new char[org.length()];
        for(int i=0; i< org.length();i++) {
        	arr[i]=org.charAt(i);
        }
        //char[] arr=arr.toCharArray();
        System.out.println(Arrays.toString(arr));
        
        // END
    }
}
