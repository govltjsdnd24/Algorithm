package c_march_09;

import java.util.Scanner;

public class BAEKJOON_20187_종이접기 {
    static int N, H;
    static char c;
    static char[] inp;
    static int[][] maps;

    static int convert(int val, int k) {
        if (k == 0) {
            switch (val) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 0;
                default:
                    return 1;
            }
        } else {
            switch (val) {
                case 0:
                    return 1;
                case 1:
                    return 0;
                case 2:
                    return 3;
                default:
                    return 2;
            }
        }
    }

    static void sv(int idx, int i1, int i2, int j1, int j2) {
        if (idx == N * 2) {
            maps[i1][j1] = H;
        } else {
            if (inp[idx] == 'U') {
                sv(idx + 1, i1, (i1 + i2) / 2, j1, j2);

                for (int i = (i1 + i2) / 2 + 1; i <= i2; i++) {
                    for (int j = j1; j <= j2; j++) {
                        maps[i][j] = convert(maps[(i1 + i2) - i][j], 0);
                    }
                }
            } else if (inp[idx] == 'D') {
                sv(idx + 1, (i1 + i2) / 2 + 1, i2, j1, j2);

                for (int i = i1; i <= (i1 + i2) / 2; i++) {
                    for (int j = j1; j <= j2; j++) {
                        maps[i][j] = convert(maps[(i1 + i2) - i][j], 0);
                    }
                }
            } else if (inp[idx] == 'R') {
                sv(idx + 1, i1, i2, (j1 + j2) / 2 + 1, j2);

                for (int i = i1; i <= i2; i++) {
                    for (int j = j1; j <= (j1 + j2) / 2; j++) {
                        maps[i][j] = convert(maps[i][(j1 + j2) - j], 1);
                    }
                }
            } else {
                sv(idx + 1, i1, i2, j1, (j1 + j2) / 2);

                for (int i = i1; i <= i2; i++) {
                    for (int j = (j1 + j2) / 2 + 1; j <= j2; j++) {
                        maps[i][j] = convert(maps[i][(j1 + j2) - j], 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        sc.nextLine(); 
        inp = sc.nextLine().toCharArray();
        H = sc.nextInt();


        maps = new int[1 << N][1 << N];

 
        sv(0, 1, 1 << N, 1, 1 << N);

 
        for (int i = 1; i <= (1 << N); i++, System.out.println())
            for (int j = 1; j <= (1 << N); j++)
                System.out.print(maps[i][j] + " ");
    }
}
