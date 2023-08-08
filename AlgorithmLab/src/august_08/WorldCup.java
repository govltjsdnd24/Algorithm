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
    
    public static void game(int current, int enemy, int gameCnt) {     //arr 배열의 행의 값으로 current와 enemy를 결정했습니다. ex) arr[1][0] = B팀의 승의 수 , arr[3][1] = D팀의 무승부의 수 등  
        if(gameCnt == 15) {    //총 15번의 경기를 하면 true반환 (A:5경기 B:4경기 C:3경기 D:2경기 E:1경기 F:0경기) 
            flag = true;       
            loop:
            for(int i=0; i<6; i++) {        //arr를 순회하면서 0보다 큰 수가 하나라도 있으면 불가능한 경기이므로 false 반환
                for(int j=0; j<3; j++) {
                    if(arr[i][j] != 0) {
                        flag = false;
                        break loop;
                    }
                }
            }
            
            return;
        }
        
        if(gameCnt == 5) {                  //current는 매번 재귀문 마다 증가하는 것이 아니기 때문에 조건문을 이용해서 증가 (다른 방법 있을거 같은데 잘 모르겠습니다ㅜ)
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
