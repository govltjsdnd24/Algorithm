package com.ssafy.b_array;

import java.util.Arrays;

/*
 * 배열
 * 		정의: 같은 데이터 타입의 순서적 나열
 * 		특징: 선언과 동시에 크기가 결정되어지고 크기가 변경되지 않는다.
 */
import java.util.Random;

public class ArrayTest_03 {
    public static void main(String[] args) {

        int N = 6;
        java.util.Random rand = new java.util.Random();
        // TODO: 1~6까지의 random 정수 5개를 저장할 배열을 만들고 값을 저장하시오.
        int r=rand.nextInt(N)+1;
        // END
        int[] arr;
        arr=new int[5]; 
        arr[0]=rand.nextInt(N)+1;
        arr[1]=rand.nextInt(N)+1;
        arr[4]=rand.nextInt(N)+1;
        arr[2]=rand.nextInt(N)+1;
        arr[3]=rand.nextInt(N)+1;
        // TODO: 위 배열에 저장된 요소 중 짝수만 더해서 합을 출력하시오.
        int sum=0;
        
        for(int i=0;i<arr.length;i++) {
        	//if even number
        	if(arr[i]%2==0) {
        		sum+=arr[i];
        	}
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
        // END
    }
}
