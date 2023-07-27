
public class BookArrayManager {
	//CRUD
	private Book[] books;
	private int index=0;
	private int MAX=10;
	private static BookArrayManager man = new BookArrayManager();
	
	private BookArrayManager() {
		books=new Book[MAX];
	}
	
	public static BookArrayManager getInstance() {
		if(man!=null)
			return man;
		else 
			man=new BookArrayManager();
		return man;
	}
	
	
	//입력
	public int addBook(Book b) {
		if(index==MAX) {
			Book[]tmp=new Book[MAX*2];
			System.arraycopy(books, 0, tmp, 0, index-1);
			books=tmp;
			MAX *=2;
		}
			
		books[index++]=b;
		return index;
	}
	//출력
	public void printBook() {
		for (int i=0;i<index;i++)
			System.out.println(books[i]);
	}
	//수정
	public void updateBook(int i, Book b) {
		System.out.println("Updating \""+books[i].getTitle() + "\" by "+books[i].getAuthor()+ " to \""+b.getTitle()+"\" by "+ b.getAuthor());
		books[i]=b;
	}
	//삭제
	public void deleteBook(int i) {
		System.out.println("Removing \""+books[i].getTitle() + "\" by "+books[i].getAuthor());
		books[i]=books[--index];
	}
	//탐색
	public Book find(String title) {
		for(Book bk: books)
			if(bk.getTitle().equals(title))
				return bk;
		return null;
	}
	public void printOnlyBook() {
//		for(Book bk: books) 
//			if(bk.getClass().getSimpleName()=="Book")
//				System.out.println(bk);
		for(Book bk: books) 
			if(!(bk instanceof Magazine )) {
				System.out.println(bk);
			}
		
	}
	public void printOnlyMagazine() {
//		for(Book bk: books) 
//			if(bk.getClass().getSimpleName()=="Magazine")
//				System.out.println(bk);
		for(Book bk: books) 
			if(bk instanceof Magazine ) {
				System.out.println(bk);
			}
	}
	
}
