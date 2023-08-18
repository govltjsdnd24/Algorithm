package h_august_18;

import java.util.*;
import java.io.*;

class Box{
	int size,count;
	public Box(int size){
		this.size=size;
		count=5;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}

public class BAEKJOON_17136_색종이붙이기 {
	
	static int[][] paper;
	
	static Box[] boxes=new Box[6];
	static int minBoxes=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int i,j;
		paper=new int[10][10];
		for(i=0;i<10;i++) {
			st= new StringTokenizer(br.readLine());
			for(j=0;j<10;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		recursion(0);
		System.out.println(minBoxes==Integer.MAX_VALUE?-1:minBoxes);
	}
	
	
	private static void recursion(int cnt) {
		int si=-1,sj=-1;
		//search for 
		L: for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(paper[i][j]==1) {
					si=i;
					sj=j;
					break L;
				}
			}
		}
		
		//si,sj 색종이를 붙일 시작위치
		//basis part (붙일위치가 없으면 그만)
		if(si==-1 && sj==-1) {
			minBoxes=Math.min(minBoxes, cnt);
			return;
		}
		
		//inductive part
		//붙일 수 있는 최대 사이즈를 구한다.
		int size= getSize(si,sj);
		//최대 사이즈 부터 붙여 나간다(백트래킹)
		while(size>0) {
			//색종이가 남아있으면
			if(boxes[size].getCount()>0) {
				//지도에 붙입니다
				for(int i=si; i< si+size; i++) {
					for (int j=sj;j<sj+size;j++) {
						paper[i][j]=0;
					}
				}
				boxes[size].setCount(boxes[size].getCount()-1);
				recursion(cnt+1);
				boxes[size].setCount(boxes[size].getCount()+1);
				for(int i=si;i<si+size;i++) {
					for(int j=sj;j<sj+size;j++) {
						paper[i][j]=1;
					}
				}
			}
			size--;
		}
		
	}


	private static int getSize(int si, int sj) {
		int size= 5;
		while(size>0) {
			boolean isOk= false;
			L:for(int i=si;i<si+size;i++) {
				for(int j=sj;sj<sj+size;j++) {
					if(i>=0&& i<10 && j>=0 && j<10 && paper[i][j]==0) {
						isOk=true;
						break L;
					}
				}
			}
			if(!isOk) {
				return size;
			}
			size--;
		}
		return 0;
	}
	
	
	
	
//	public static void recursion(int r,int c,int size,int usedBoxes) {
//		if(!placementAvailable()) {
//			minBoxes=Math.min(minBoxes, usedBoxes);
//			return;
//		}
//		int sizeLimit=findLimit(r,c);
//		
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				for(int k=0;k<sizeLimit;k++) {
//					int er=r+size; int ec=c+size;
//					if(er>=0 && er<10 && ec>=0 && ec<10 && !filled[er][ec]) {
//						placeBox();
//						recursion(r+i);
//						unplaceBox();
//					}
//				}
//			}
//		}
//		
//		
//	}

}
