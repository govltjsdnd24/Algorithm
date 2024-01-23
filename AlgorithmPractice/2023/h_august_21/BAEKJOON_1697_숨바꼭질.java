package h_august_21;

import java.util.*;

class Place{
	int loc; int count;
	Place (int loc, int count){
		this.loc=loc; this.count=count;
	}
}

public class BAEKJOON_1697_숨바꼭질 {
	static int N,K,moves;
	static boolean visited[]= new boolean [100001];
	
	static int[] dr= {-1,1,2};
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		K=scan.nextInt();
		moves=0;
		
		System.out.println(bfs());
		scan.close();
	}
	
	public static int bfs() {
		Queue<Place> nQ= new LinkedList<Place>();
		nQ.offer(new Place(N,0));
		visited[N]=true;
		
		int breadth=0;
		while(!nQ.isEmpty()) {
			Place nN=nQ.poll();
			if(nN.loc==K)
				return nN.count;
			for(int i=0;i<3;i++) {
				Place nnN=new Place(nN.loc,nN.count);
				if(i==2) {
					nnN.loc*=2;
				}
				else {
					nnN.loc+=dr[i];
					
				}
				
				if(nnN.loc>=0 && nnN.loc<=100000 && !visited[nnN.loc]) {
					nnN.count++;
					nQ.offer(nnN);
					visited[nnN.loc]=true;
				}
				
			}
			breadth++;
		}
		return breadth;
	}

}
