package july_21.hwjava04;

public class TV extends Product{
	
	private String dType;
	private double inch;
	
	public TV() {
		super();
	}
	public TV(String sNum, String name, int price, int num,String dType,double inch) {
		super(sNum, name, price, num);
		this.dType = dType;
		this.inch = inch;
	}

	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public double getInch() {
		return inch;
	}
	public void setInch(double inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [sNum=" + getsNum() + ", name=" + getName() + ", price=" + getPrice() + ", num=" + getNum() + ", dType=" + dType + ", inch=" + inch + "]";
	}
	
	
	
	
	
	
	
	
	
}
