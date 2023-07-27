package com.ssafy.b_array;

public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";

        // TODO: String "1234567890" 의 자리 별 수를 1차원 배열에 저장하고 배열을 순회해서 그 합을 출력하시오.
        char[] arr= org.toCharArray();
        int []arr2=new int[arr.length];
        for(int i=0;i<org.length();i++) {
        	arr2[i]=arr[i]-'0';
        	System.out.println(arr2[i]);
        }
        //System.out.println(arr[0]-'0');

        // END
    }
}
