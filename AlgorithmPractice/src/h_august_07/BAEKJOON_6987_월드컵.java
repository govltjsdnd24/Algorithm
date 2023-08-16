package h_august_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Country{
	private int wins,draws,losses;
	public Country(int wins,int draws, int losses) {
		this.wins=wins; this.draws=draws; this.losses=losses;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public boolean isZero() {
		if(this.losses==0 && this.draws== 0 && this.wins==0)
			return true;
		else 
			return false;
	}
}


public class BAEKJOON_6987_월드컵 {
	
	static Country [] distribution=new Country [6];
	static Country [] comparative=new Country[6];
	static int[] protagon= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] enemy= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static boolean possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int i,j;
		
		
		for(i=0;i<4;i++) {
			possible=true;
			for(j=0;j<6;j++) {
				st = new StringTokenizer(br.readLine());
				distribution[j]=new Country(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				if(distribution[j].getWins()+distribution[j].getDraws()+distribution[j].getLosses()!=5) {
					possible=false; break;
				}
			}
			if(possible)
				resultChecker(0);
			
			int outcome=possible?1:0;
			System.out.print(outcome);
			if(i!=3)
				System.out.print(" ");
		}
		
		
	}
	
	private static void resultChecker(int match) {
		if(match==15) {
			for(int i=0;i<6;i++) {
				if(!distribution[i].isZero()){
					possible=false;
					return;
				}
			}
			return;
		}
		
		int protWins=distribution[protagon[match]].getWins();
		int protDraws=distribution[protagon[match]].getDraws();
		int protLosses=distribution[protagon[match]].getLosses();
		
		int enemWins=distribution[enemy[match]].getWins();
		int enemDraws=distribution[enemy[match]].getDraws();
		int enemLosses=distribution[enemy[match]].getLosses();
		
		//if protagonist wins
		if(protWins>0 && enemLosses>0) {
			distribution[protagon[match]].setWins(protWins-1);
			distribution[enemy[match]].setLosses(enemLosses-1);
			resultChecker(match+1);
			distribution[protagon[match]].setWins(protWins+1);
			distribution[enemy[match]].setLosses(enemLosses+1);
		}
		//if protagonist losses
		if(protLosses>0 && enemWins>0) {
			distribution[protagon[match]].setLosses(protLosses-1);
			distribution[enemy[match]].setWins(enemWins-1);
			resultChecker(match+1);
			distribution[protagon[match]].setLosses(protLosses+1);
			distribution[enemy[match]].setWins(enemWins+1);
		}
		//if protagonist draws
		if(protDraws>0 && enemDraws>0) {
			distribution[protagon[match]].setDraws(protDraws-1);
			distribution[enemy[match]].setDraws(enemDraws-1);
			resultChecker(match+1);
			distribution[protagon[match]].setDraws(protDraws+1);
			distribution[enemy[match]].setDraws(enemDraws+1);
		}
		
			
			
			
	}
	
	

}
