package l_december_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName : l_december_25
 * fileName : BAEKJOON_1018
 * author : KRSWC_ADM
 * date : 2024-12-26
 * description :
 * 요약 : 체스판 다시 칠하기
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-26         KRSWC_ADM          최초 생성
 */
public class BAEKJOON_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        char[][]grid=new char[N][M];
        for(int i=0;i<N;i++) {
            String line=br.readLine();
            for(int j=0;j<M;j++) {
                grid[i][j]=line.charAt(j);
            }
        }

        char actual;
        char cursor;
        int current;
        int min=Integer.MAX_VALUE;

        //b-start = 0, w-start = 1
        for(int bw=0;bw<2;bw++) {
            if(bw==0) cursor='B';
            else cursor='W';

            for (int r = 0; r <= N - 8; r++) {
                for (int c = 0; c <= M - 8; c++) {
                    current=0;
                    for (int y = 0; y < 8; y++) {
                        for (int x = 0; x < 8; x++) {
                            //put actual value
                            actual=grid[r+y][c+x];

                            if (actual != cursor)
                                current++;

                            //oscillate
                            if(x!=7)
                                cursor=oscillate(cursor);
                        }
                    }

                    min=Math.min(current, min);

                }
            }
        }

        System.out.print(min);

    }

    private static char oscillate(char cursor){
        if(cursor=='B')
            cursor='W';
        else cursor='B';
        return cursor;
    }
}
