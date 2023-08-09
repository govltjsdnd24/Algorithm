package edu.ssafy.datastructure.tree;

import java.util.Arrays;

class MaxHeap{
	private int [] elements;
	private int pos;
	
	public MaxHeap() {
		this(10);
	}
	public MaxHeap(int size) {
		elements=new int[size+1];
	}
	public boolean isFull() {
		return pos==elements.length-1;
	}
	public void print() {
		for(int i=1; i<elements.length;i++) {
			System.out.println(elements[i]+" ");
		}
		System.out.println();
	}
	public void swap(int [] arr,int i,int j) {
		int tmp= arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public void offer(int data) {
		//다 찼으면 2배로 늘리기
		if(isFull()) {
			elements=Arrays.copyOf(elements,elements.length*2);
		}
		elements[++pos]=data;
		int idx=pos; //현재 위치
		while(idx>1 && elements[idx]>elements[idx/2]) { 
			//루트가 아니고 자식이 부모보다 크다면 swap
			swap(elements,idx,idx/2);
			idx/=2;
		}
	}
	
	public int poll() {
		if(pos==0) return -1;
		int res= elements[1];
		//루트의 값을 배열에 마지막으로 교체
		elements[1]=elements[pos];
		//마지막 원소가 있던 자리를 0으로 초기화
		elements[pos--]=0;
		//힙 정렬
		heapify();
		return res;
		
	}
	
	public void heapify() {
		//첫번쨰 값과 자식을 비교해서 자식이 크다면 교체하는 것을 반복
		int idx=1;
		//자식의 위치가 현재 값 보다 작거나 같으면
		while(idx*2<=pos) {
			//부모가 양쪽 자식보다 크다면 정지
			if(elements[idx]>=elements[idx*2]&& elements[idx]>= elements[idx*2+1]) {
				break;
			}
			//else 두 자식 중 큰 값과 부모를 교환한다.
			if(elements[idx*2]>elements[idx*2+1]) {
				swap(elements,idx,idx*2);
				idx=idx*2;
			} 
			else {
				swap(elements,idx,idx*2+1);
				idx=idx*2+1;
			}

		}
	}
}
	

public class HeapTest {

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		heap.offer(4);
		heap.offer(7);
		heap.offer(3);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}

}
