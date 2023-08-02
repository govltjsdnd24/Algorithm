package im.book;

public class Magazine extends Book{
	private int price,year,month;
	public Magazine() {
	}
	public Magazine(String title, String author, String publisher, String desc, int price, int year, int month) {
		super(title,author,publisher,desc,price);
		this.price=price;
		this.year=year;
		this.month=month;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine [title=" + getTitle() + ", author=" + getAuthor() + ", publisher=" + getPublisher() + ", desc=" + getDesc()
				+ ", price=" + getPrice() + "Magazine [price=" + price + ", year=" + year + ", month=" + month + "]";
	}
	
	
	
}
