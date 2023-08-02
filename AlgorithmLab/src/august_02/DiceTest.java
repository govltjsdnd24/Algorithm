package august_02;
import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		int M= sc.nextInt();
		numbers= new int[N];
		switch(M) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2:   // 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3:   // 중복조합
			dice3(0,1);
			break;
		case 4:   // 순열
			isSelected = new boolean[7];
			dice4(0,1);
			break;
		}
		
	}
	
	//중복된 주사위 눈 가능
	private static void dice1(int cnt) { //cnt+1번째 주사위 던지기, cnt: 기존까지 던져진 주사위 횟수
		//한 번 던질 때 가능한 상황에 대한 시도 (1,2,3,4,5,6 주사위 눈이 가능)
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <=6; i++) { 
			//기존 주사위의 눈과  중복되는지 체크
			numbers[cnt] = i;
			//현 주사위의 눈이 i로 결정된 상태로 다음 주사위 던지러 가기
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) { //cnt+1번째 주사위 던지기, cnt: 기존까지 던져진 주사위 횟수
		//한 번 던질 때 가능한 상황에 대한 시도 (1,2,3,4,5,6 주사위 눈이 가능)
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <=6; i++) { 
			//기존 주사위의 눈과  중복되는지 체크
			if(isSelected[i]) 
				continue;
			
			numbers[cnt] = i;
			isSelected[i]=true;
			//현 주사위의 눈이 i로 결정된 상태로 다음 주사위 던지러 가기
			dice2(cnt+1);
			//현 주사위의 눈을 다른 선택지로 시도하기 위한 준비
			isSelected[i]=false;
		}
	}
	
	//중복 조합
	private static void dice3(int cnt,int start) { //start: 시작 주사위 눈의 수
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <=6 ; i++) { // i : 뽑는 수
			numbers[cnt]=i;
			dice4(cnt+1,i);
		}
	}
	
	//조합
	private static void dice4(int cnt,int start) { //start: 시작 주사위 눈의 수
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <=6 ; i++) { // i : 뽑는 수
			numbers[cnt]=i;
			dice4(cnt+1,i+1);
		}
	}

}
