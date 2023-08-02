package im.book;

public class Book {
	private String title,author,publisher,desc;
	private int price;
	public Book() {};
	public Book(String title, String author, String publisher, String desc, int price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", desc=" + desc
				+ ", price=" + price + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
