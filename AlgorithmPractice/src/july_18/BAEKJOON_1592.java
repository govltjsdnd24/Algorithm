package july_18;
import java.util.Scanner;

public class BAEKJOON_1592 {

	public static void main(String[] args) {
		int i,j;
		int N,M,L;
		int []players;
		int possession;
		int counter;
		boolean game_over;

		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt(); //seats from 1 to N
		M=sc.nextInt(); //max catches
		L=sc.nextInt(); //next throw base
		
		players=new int[N];
		
		//player 1 catches the ball
		players[0]=1;
		possession=0;
		
		counter=0;
		game_over=false;

		while(true) {
			//check at the end of each turn if someone caught M times
			for(i=0;i<N;i++)
				if(players[i]>=M)
					game_over=true;
			if(game_over)
				break;
			//if odd
			if(players[possession]%2==1) 
				possession+=L;
			//if even
			else if(players[possession]%2==0)
				possession-=L;
			
			//if out of bounds
			if(possession>=N)
				possession-=N;
			else if(possession<0)
				possession+=N;
			
			//player catch count increase
			players[possession]++;
			counter++;
			

		}
		System.out.println(counter);
		
	}

}
