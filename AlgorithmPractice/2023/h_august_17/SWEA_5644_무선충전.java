package h_august_17;

import java.util.*;

class AccessPoint implements Comparable<AccessPoint>{
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
	@Override
	public int compareTo(AccessPoint ap) {
		return Integer.compare(p, ap.getP());
	}
	@Override
	public String toString() {
		return "AccessPoint [r=" + r + ", c=" + c + ", d=" + d + ", p=" + p + "]";
	}
	
	public boolean equals(AccessPoint ap) {
		if(this.r==ap.getR() && this.c==ap.getC() && this.d==ap.getD() && this.p==ap.getP())
			return true;
		return false;
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
	@Override
	public String toString() {
		return "Person [r=" + r + ", c=" + c + ", charge=" + charge + ", current=" + current + "]";
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
				
			}
			for(i=0;i<M;i++) {
				bMove[i]=scan.nextInt();
				
			}
			
			for(i=0;i<A;i++) {
				int x=scan.nextInt();
				int y=scan.nextInt();
				int s=scan.nextInt();
				int pow=scan.nextInt();
				APs[i]=new AccessPoint(y,x,s,pow);
			}
			
			calculateBattery();
			System.out.println("#"+testcase+" "+(aPer.getCharge()+bPer.getCharge()));
		}
		scan.close();
	}
	
	private static void calculateBattery() {
		int i;
		for(i=0;i<=M;i++) {
			setZone();
			if(aPer.getCurrent()!=null)
				aPer.setCharge(aPer.getCharge()+aPer.getCurrent().getP());
			if(bPer.getCurrent()!=null) 
				bPer.setCharge(bPer.getCharge()+bPer.getCurrent().getP());
			if(i!=M)
				movePeople(i);
		}
	}
	
	private static void movePeople(int i) {
		aPer.setR(aPer.getR()+dr[aMove[i]]);
		aPer.setC(aPer.getC()+dc[aMove[i]]);
		bPer.setR(bPer.getR()+dr[bMove[i]]);
		bPer.setC(bPer.getC()+dc[bMove[i]]);
	}
	
	private static void setZone() {
		ArrayList<AccessPoint> aAPs=new ArrayList<>();
		ArrayList<AccessPoint> bAPs=new ArrayList<>();
		
		//put a and b's available APs into arraylists
		for(int i=0;i<A;i++) {
			if(APs[i].getD()>=Math.abs(aPer.getR()-APs[i].getR())+Math.abs(aPer.getC()-APs[i].getC())){
				aAPs.add(APs[i]);
			}
		}
		for(int i=0;i<A;i++) {
			if(APs[i].getD()>=Math.abs(bPer.getR()-APs[i].getR())+Math.abs(bPer.getC()-APs[i].getC())){
				bAPs.add(APs[i]);
			}
		}
		
		int sum=0;
		AccessPoint aAssign=null;
		AccessPoint bAssign=null;
		
		if(bAPs.isEmpty() && !aAPs.isEmpty())
			aAssign=Collections.max(aAPs);
		else if(aAPs.isEmpty() && !bAPs.isEmpty())
			bAssign=Collections.max(bAPs);
		else if(!aAPs.isEmpty() && !bAPs.isEmpty()){
			for(int i=0;i<aAPs.size();i++) {
				for(int j=0;j<bAPs.size();j++) {
					AccessPoint aTemp=aAPs.get(i);
					AccessPoint bTemp=bAPs.get(j);
					
					if(aTemp.equals(bTemp)) {
						if(aTemp.getP()>sum) {
							aAssign=new AccessPoint(aTemp.getR(),aTemp.getC(),aTemp.getD(),aTemp.getP()/2);
							bAssign=new AccessPoint(aTemp.getR(),aTemp.getC(),aTemp.getD(),aTemp.getP()/2);
							sum=aTemp.getP();
						}
					}
					else {
						if(aTemp.getP()+bTemp.getP()>sum) {
							aAssign=aTemp;
							bAssign=bTemp;
							sum=aTemp.getP()+bTemp.getP();
						}
					}
					
					
				}
			}
		}
		
		aPer.setCurrent(aAssign);
		bPer.setCurrent(bAssign);
//		System.out.println("a: "+aPer.getCurrent());
//		System.out.println("b: "+bPer.getCurrent());
//		System.out.println();
	}
	
	

}
