package a_january_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1427_소트인사이드 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 char[]numArr= br.readLine().toCharArray();
		 int[] intArr= new int[numArr.length];
		 for(int i=0;i<numArr.length;i++) {
			 intArr[i]=(numArr[i]-'0')*-1;
		 }
		 Merge merge = new Merge();
		 merge.sort(intArr,0,intArr.length-1);
		 for(int num:intArr)
			 System.out.print(num*-1);
		 
	}
	
	
}

class Merge{

	
	public void sort(int[] arr, int left, int right) {
	    mergeSort(arr, left, right);
	}
	
	private void mergeSort(int[] arr, int left, int right) {
	    int mid = 0;
	    if (left < right) {
	        mid = (left + right) / 2; // 데이터 리스트의 중앙 인덱스를 구함
	        mergeSort(arr, left, mid); // 중앙을 기준으로 왼쪽 데이터들을 분할한다.
	        mergeSort(arr, mid + 1, right); // 중앙을 기준으로 오른쪽 데이터들을 분할한다.
	        merge(arr, left, mid, right); // 정복 및 결합 과정을 진행한다.
	    }
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
	    int leftIndex = left;
	    int rightIndex = mid + 1;
	    int sortedIndex = left;
	    int[] tmpSortedArray = new int[right + 1];
	
	    while(leftIndex <= mid && rightIndex <= right) {
	        if (arr[leftIndex] <= arr[rightIndex]) {
	            tmpSortedArray[sortedIndex++] = arr[leftIndex++];
	        }
	        else {
	            tmpSortedArray[sortedIndex++] = arr[rightIndex++];
	        }
	    }
	
	    if (leftIndex > mid) {
	        for(int i=rightIndex; i<=right; i++) {
	            tmpSortedArray[sortedIndex++] = arr[i];
	        }
	    }
	    else {
	        for(int i=leftIndex; i<=mid; i++) {
	            tmpSortedArray[sortedIndex++] = arr[i];
	        }
	    }
	
	    for(int i=left; i<=right; i++) {
	        arr[i] = tmpSortedArray[i];
	    }
	}
}