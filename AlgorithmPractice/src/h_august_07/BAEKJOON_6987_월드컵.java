package h_august_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Country{
	private int wins,draws,losses;
	public Country() {
		this(0,0,0);
	}
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
			st = new StringTokenizer(br.readLine());
			for(j=0;j<6;j++) {	
				comparative[j]=new Country();
				distribution[j]=new Country(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				if(distribution[j].getWins()+distribution[j].getDraws()+distribution[j].getLosses()!=5) {
					possible=false; break;
				}
			}
			
			if(possible) {
				possible=false;
				resultChecker(0);
			}
			
			
			int outcome=possible?1:0;
			System.out.print(outcome);
			if(i!=3)
				System.out.print(" ");
		}
		
		
	}
	
	private static void resultChecker(int match) {
		if(match==15) {
			for(int i=0;i<6;i++) {
				
				if(!(comparative[i].getWins()==distribution[i].getWins()&&comparative[i].getDraws()==distribution[i].getDraws()&&comparative[i].getLosses()==distribution[i].getLosses())){
					return;
				}
			}
			possible=true;
			return;
		}
		
		int protWins=distribution[protagon[match]].getWins();
		int protDraws=distribution[protagon[match]].getDraws();
		int protLosses=distribution[protagon[match]].getLosses();
		
		int enemWins=distribution[enemy[match]].getWins();
		int enemDraws=distribution[enemy[match]].getDraws();
		int enemLosses=distribution[enemy[match]].getLosses();
		
		//if protagonist wins
		if(comparative[protagon[match]].getWins()<protWins && comparative[enemy[match]].getLosses()<enemLosses) {
			comparative[protagon[match]].setWins(comparative[protagon[match]].getWins()+1);
			comparative[enemy[match]].setLosses(comparative[enemy[match]].getLosses()+1);
			resultChecker(match+1);
			comparative[protagon[match]].setWins(comparative[protagon[match]].getWins()-1);
			comparative[enemy[match]].setLosses(comparative[enemy[match]].getLosses()-1);
		}
		//if protagonist wins
		if(comparative[protagon[match]].getDraws()<protDraws && comparative[enemy[match]].getDraws()<enemDraws) {
			comparative[protagon[match]].setDraws(comparative[protagon[match]].getDraws()+1);
			comparative[enemy[match]].setDraws(comparative[enemy[match]].getDraws()+1);
			resultChecker(match+1);
			comparative[protagon[match]].setDraws(comparative[protagon[match]].getDraws()-1);
			comparative[enemy[match]].setDraws(comparative[enemy[match]].getDraws()-1);
		}
		//if protagonist losses
		if(comparative[protagon[match]].getLosses()<protLosses && comparative[enemy[match]].getWins()<enemWins) {
			comparative[protagon[match]].setLosses(comparative[protagon[match]].getLosses()+1);
			comparative[enemy[match]].setWins(comparative[enemy[match]].getWins()+1);
			resultChecker(match+1);
			comparative[protagon[match]].setLosses(comparative[protagon[match]].getLosses()-1);
			comparative[enemy[match]].setWins(comparative[enemy[match]].getWins()-1);
		}
		
			
			
			
	}
	
	

}
