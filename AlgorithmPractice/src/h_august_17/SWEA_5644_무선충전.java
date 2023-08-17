package h_august_17;

import java.util.Scanner;

class AccessPoint{
	private int r,c,d,p;
	public AccessPoint(int r,int c, int d, int p) {
		this.r=r; this.c=c; this.d=d; this.p=p;
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	public int getD() {
		return d;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p=p;
	}
}

class Person{
	private int r,c,charge;
	private AccessPoint current;
	public Person(int r,int c) {
		this.r=r; this.c=c; current=null; this.charge=0;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public AccessPoint getCurrent() {
		return current;
	}
	public void setCurrent(AccessPoint current) {
		this.current = current;
	}
	public int getCharge() {
		return this.charge;
	}
	public void setCharge(int charge) {
		this.charge=charge;
	}
	
	
}

public class SWEA_5644_무선충전 {

	static int[] dr= {0,-1,0,1,0};
	static int[] dc= {0,0,1,0,-1};
	
	static int[] aMove;
	static int[] bMove;
	static AccessPoint[] APs;
	
	static Person aPer;
	static Person bPer;
	
	static int M,A;
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int testcase,T;
		int i,j;
		
		T=scan.nextInt();
		for(testcase=1;testcase<=T;testcase++) {
			M=scan.nextInt();
			A=scan.nextInt();
			
			aMove=new int[M];
			bMove=new int[M];
			APs=new AccessPoint[A];
			
			aPer=new Person(1,1);
			bPer=new Person(10,10);
			
			for(i=0;i<M;i++) {
				aMove[i]=scan.nextInt();
				bMove[i]=scan.nextInt();
			}
			
			for(i=0;i<A;i++) {
				APs[i]=new AccessPoint(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
			}
			
			calculateBattery();
			System.out.println("#"+testcase+" "+(aPer.getCharge()+bPer.getCharge()));
		}
		scan.close();
	}
	
	private static void calculateBattery() {
		int i;
		for(i=0;i<M;i++) {
			batteryAssign();
			aPer.setCharge(aPer.getCharge()+aPer.getCurrent().getP());
			bPer.setCharge(bPer.getCharge()+bPer.getCurrent().getP());
		}
	}
	
	private static int batteryAssign() {
		setZone(aPer);
		setZone(bPer);
		
		//if aPer and bPer in same zone
		if(aPer.getCurrent()==bPer.getCurrent()) {
			//divide power into half
			aPer.getCurrent().setP(aPer.getCurrent().getP()/2);
		}
		
		return -1;
	}
	
	private static void setZone(Person person) {
		for(int i=0;i<A;i++) {
			if(APs[i].getD()>=Math.abs(person.getR()-APs[i].getR())+Math.abs(person.getC()-APs[i].getC())){
				//if person is inside no zone, or the zone has more power than the former
				if(person.getCurrent()==null || person.getCurrent().getP()<APs[i].getP())
					person.setCurrent(APs[i]);
			}
		}
	}
	
	

}
