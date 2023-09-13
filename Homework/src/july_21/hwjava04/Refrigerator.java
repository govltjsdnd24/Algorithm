package july_21.hwjava04;

public class Refrigerator extends Product{
	private double size;

	public Refrigerator() {
		super();
	}
	public Refrigerator(String sNum, String name, int price, int num, double size) {
		super(sNum, name, price, num);
		this.size=size;
	}

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Refrigerator [sNum=" + getsNum() + ", name=" + getName() + ", price="
				+ getPrice() + ", num=" + getNum() + ", size=" + size +"]";
	}
	
	

}
