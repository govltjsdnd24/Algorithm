package july_21;

public class Product {
	private String sNum,name;
	private int price, num;
	
	public Product() {
		super();
	}

	public Product(String sNum, String name, int price, int num) {
		super();
		this.sNum = sNum;
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getsNum() {
		return sNum;
	}
	public void setsNum(String sNum) {
		this.sNum = sNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Product [sNum=" + sNum + ", name=" + name + ", price=" + price + ", num=" + num + "]";
	}
	
	
	
	
}
