package edu.ssafy.disjointsets;

public class DisjointSetTest {

	static int N;//초기 집합의 개수
	static int parents[];
	
	private static void make() {
		parents= new int[N];
		for (int i = 0; i < N; i++) {
			parents[i]=i; //모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
		}
	}
	
	private static int find(int a) {
		if(parents[a]==a)
			return a;
		return parents[a]=find(parents[a]);
	}
	
	public boolean union(int a,int b) { // a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true 반환, 아니면 false 반환 
		int aRoot= find(a);
		int bRoot= find(b);
		
		if(aRoot==bRoot) //서로의 대표가 같으면 같은 집합, so can't unite
			return false;
		 //union 처리 (bRoot를 aRoot 아래로 붙이기)
		parents[bRoot]= aRoot;
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=5;
		make();
		for (int i = 0; i < N; i++) {
			System.out.println("find "+i+" "+find(i));
		}
	}

}
