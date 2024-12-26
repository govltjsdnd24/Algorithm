package l_december_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName : l_december_26
 * fileName : BAEKJOON_1436
 * author : KRSWC_ADM
 * date : 2024-12-26
 * description :
 * 요약 : 영화감독 숌
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-26         KRSWC_ADM          최초 생성
 */
public class BAEKJOON_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int numbering=665;
        String num_str=Integer.toString(numbering);

        for(int i=0;i<N;i++) {
            do{
                numbering++;
                num_str=Integer.toString(numbering);
            }
            while(!num_str.contains("666"));
        }
        System.out.print(num_str);
    }
}
