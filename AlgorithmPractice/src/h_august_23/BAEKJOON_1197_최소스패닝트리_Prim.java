package h_august_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BAEKJOON_1197_최소스패닝트리_Prim {
    
    static class Vertex implements Comparable<Vertex> {
        int e, w;
        Vertex(int e, int w) {
            this.e = e;this.w = w;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }
    
    static int V,E;
    static int Ans;

    public static void main(String[] args) {
        //System.setIn(최소스패닝트리_Prim_matrix.class.getResourceAsStream("최소스패닝트리.txt"));
        Scanner sc = new Scanner(System.in);
        
        Ans = 0;
        V = sc.nextInt();
        E = sc.nextInt();

        //인접 행렬
        int[][] adj = new int[V+1][V+1];
        
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            adj[s][e]=adj[e][s]=w;
        }
        
        //방문배열
        boolean[] visited = new boolean[V+1];
        //거리배열
        int[] dist = new int[V+1];
        //무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        //임의의 정점 선택
        dist[1] = 0;

        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Q.add(new Vertex(1, dist[1]));

        int cnt = 0;
        while (!Q.isEmpty()) {
            Vertex cur = Q.poll();
            if (visited[cur.e]) continue;

            Ans += cur.w;
            cnt++;
            if (cnt == V) break;

            visited[cur.e]=true;
            int size=adj.length;
            for (int i = 1; i < size; i++) {
            	
                if (!visited[i] &&dist[i]>adj[cur.e][i]&&adj[cur.e][i]>0) {
                    dist[i]=adj[cur.e][i];
                    Q.add(new Vertex(i, adj[cur.e][i]));
                }
            }
        }

        System.out.println(Ans);
        sc.close();
    }

    
}
