package august_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class WorldCup {
    
    static int[][] arr;
    static boolean flag;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int test_case=0; test_case<4; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            arr = new int[6][3];
            flag = false;
            
            for(int i=0; i<6; i++) {
                for(int j=0; j<3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }            
            
            game(0, 1, 0);  
            
            if (flag) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
            
        }
        
    }
    
    public static void game(int current, int enemy, int gameCnt) {     //arr �迭�� ���� ������ current�� enemy�� �����߽��ϴ�. ex) arr[1][0] = B���� ���� �� , arr[3][1] = D���� ���º��� �� ��  
        if(gameCnt == 15) {    //�� 15���� ��⸦ �ϸ� true��ȯ (A:5��� B:4��� C:3��� D:2��� E:1��� F:0���) 
            flag = true;       
            loop:
            for(int i=0; i<6; i++) {        //arr�� ��ȸ�ϸ鼭 0���� ū ���� �ϳ��� ������ �Ұ����� ����̹Ƿ� false ��ȯ
                for(int j=0; j<3; j++) {
                    if(arr[i][j] != 0) {
                        flag = false;
                        break loop;
                    }
                }
            }
            
            return;
        }
        
        if(gameCnt == 5) {                  //current�� �Ź� ��͹� ���� �����ϴ� ���� �ƴϱ� ������ ���ǹ��� �̿��ؼ� ���� (�ٸ� ��� ������ ������ �� �𸣰ڽ��ϴ٤�)
            current = 1;
            enemy = current+1;
        } else if (gameCnt == 9) {
            current = 2;
            enemy = current+1;
        } else if (gameCnt == 12) {
            current = 3;
            enemy = current+1;
        } else if (gameCnt == 14) {
            current = 4;
            enemy = current+1;
        }
         
        if(arr[current][0] > 0 && arr[enemy][2] > 0) {   
            arr[current][0]--;
            arr[enemy][2]--;
            game(current, enemy+1, gameCnt+1);
            arr[current][0]++;
            arr[enemy][2]++;
        }
        if(arr[current][1] > 0 && arr[enemy][1] > 0) {
            arr[current][1]--;
            arr[enemy][1]--;
            game(current, enemy+1, gameCnt+1);
            arr[current][1]++;
            arr[enemy][1]++;
        }
        if(arr[current][2] > 0 && arr[enemy][0] > 0) {
            arr[current][2]--;
            arr[enemy][0]--;
            game(current, enemy+1, gameCnt+1);
            arr[current][2]++;
            arr[enemy][0]++;
        }
        
        
    }
    
}
