package com.ssafy.b_array;

public class ArrayTest_15 {
    public static void main(String[] args) {
        // TODO: 문제에서 제시하는 2차원 배열을 생성하고 내용을 출력하시오.
    	//int[][]arr= new int[2][2];
    	int[][]arr = new int [][] {{1,3,5},{2,4,6,7}};
    	
    	for( int i=0; i<arr.length;i++) {
    		for(int j=0; j<arr[i].length;j++) {
    			System.out.print(arr[i][j]+" ");
    		}
    		System.out.println();
    	}
        // END
    }
}
