//VO class
public class Dispatcher {

	public static void main(String[] args) {
		
		BookArrayManager man= BookArrayManager.getInstance();
		BookArrayManager man1= BookArrayManager.getInstance();
		
		man.addBook(new Book("java", "ssafy", "ssafy", "좋아요", 10000));
		man1.addBook(new Book("java", "ssafy", "ssafy", "좋아요", 20000));
		man.addBook(new Book("java", "ssafy", "ssafy", "좋아요", 30000));
		man1.addBook(new Book("java", "ssafy", "ssafy", "좋아요", 40000));
		man.addBook(new Book("java", "ssafy", "ssafy", "좋아요", 50000));
		
		man.addBook(new Magazine("algorithm", "ssafy","ssafy","더좋아요",20000, 2023, 7));
		man1.addBook(new Magazine("algorithm", "ssafy","ssafy","더좋아요",20000, 2023, 8));
		man.addBook(new Magazine("algorithm", "ssafy","ssafy","더좋아요",20000, 2023, 9));
		man1.addBook(new Magazine("there", "ssafy","ssafy","더좋아요",20000, 2023, 10));
		man.addBook(new Magazine("here", "ssafy","ssafy","더좋아요",20000, 2023, 11));
		
		man.deleteBook(9);
		man.deleteBook(4);
		//man.printBook();
		man.updateBook(7,new Magazine("a", "b","c","d",1, 2, 3));
		man.printOnlyMagazine();

	}


}
