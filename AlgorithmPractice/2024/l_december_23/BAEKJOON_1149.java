package l_december_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName : l_december_23
 * fileName : BAEKJOON_1149
 * author : KRSWC_ADM
 * date : 2024-12-26
 * description :
 * 요약 : RGB거리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-26         KRSWC_ADM          최초 생성
 */
public class BAEKJOON_1149 {

//    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        //int[][] houses= new int[N][3];
        //boolean[][] visited= new boolean[N][3];
        int[][]dp=new int[N][3];
        int red,green,blue;
        int min;

        //fill in 2d array
        //red-green-blue
//        for(int i=0;i<N;i++) {
//            st=new StringTokenizer(br.readLine());
//            for(int j=0;j<3;j++)
//                houses[i][j]=Integer.parseInt(st.nextToken());
//        }
        st=new StringTokenizer(br.readLine());
        dp[0][0]=Integer.parseInt(st.nextToken());
        dp[0][1]=Integer.parseInt(st.nextToken());
        dp[0][2]=Integer.parseInt(st.nextToken());

        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            red=Integer.parseInt(st.nextToken());
            green=Integer.parseInt(st.nextToken());
            blue=Integer.parseInt(st.nextToken());

            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+red;
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+green;
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+blue;
        }
//        dfs(houses,visited,0,0,-1);

        min=Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2]));

        System.out.print(min);
    }


//    private static void dfs (int[][] houses, boolean[][] visited,  int depth, int sum, int last_color){
//        //basis part
//        if(sum>min) return;
//
//        if(depth==houses.length) {
//            min=Math.min(min,sum);
//            return;
//        }
//
//        //inductive part
//        for (int color = 0; color < 3; color++) {
//            if(last_color!=color && !visited[depth][color]) {
//                visited[depth][color]=true;
//                dfs(houses,visited,depth+1,sum+houses[depth][color],color);
//                visited[depth][color]=false;
//            }
//        }
//    }


}
