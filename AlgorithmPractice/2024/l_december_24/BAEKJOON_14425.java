package l_december_24;

/**
 * packageName : l_december_24
 * fileName : BAEKJOON_14425
 * author : KRSWC_ADM
 * date : 2024-12-24
 * description :
 * 요약 : 문자열 집합
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-24         KRSWC_ADM          최초 생성
 */

import java.io.*;
import java.util.*;

public class BAEKJOON_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String>S = new HashSet<>();
        String str;
        int answer=0;

        for (int cnt = 0; cnt < N; cnt++) {
            str = br.readLine();
            S.add(str);
        }

        for(int cnt=0;cnt<M;cnt++) {
            str=br.readLine();
            if(S.contains(str)){
                answer++;
            }
        }


        System.out.println(answer);

    }
}