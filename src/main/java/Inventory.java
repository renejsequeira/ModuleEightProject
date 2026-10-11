import java.util.LinkedList;

public class Inventory {
	LinkedList<Book> bookInventory = new LinkedList<Book>();
	
	LinkedList<Book> lendingInventory = new LinkedList<Book>();
	public void addBook(int id,String t,String a, int i,int p) {
		Book addBook = new Book(id,t,a,i,p);
		bookInventory.add(addBook);
	}
	
	public boolean borrowBook(int bookID) {
		for(Book book:bookInventory) {
			if(book.getBookID()== bookID) {
				bookInventory.remove(book);
				lendingInventory.add(book);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean returnBook(int bookID) {
		for(Book book:lendingInventory) {
			if(book.getBookID()== bookID) {
				bookInventory.add(book);
				lendingInventory.remove(book);
				return true;
			}
			
		}
		return false;
	}
	
	
	public void printAll() {
		for(Book book : bookInventory) {
			book.printBookInfo(book);
		}
	}
	
	public LinkedList<Book> searchByTitle(String mt){
		LinkedList <Book> matching = new LinkedList<>();		
		
		for(Book b: bookInventory) {
			String ct =b.getTitle();
			
			if(ct.toUpperCase().contains(mt.toUpperCase())) {
				matching.add(b);
			}
		}
		return matching;
	}
	
	public boolean idDuplicate(int i) {
		for(Book b:bookInventory) {
			if(b.getBookID() == i) {
				return true;
			}
			
		}
		return false;
	}
	
	
	public boolean isbnDuplicate(int i) {
		for(Book b: bookInventory) {
			if(b.getISBN() == i) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bookBorrow (int i) {
		for(Book b: lendingInventory) {
			if(b.getBookID()== i) {
				return true;
			}
		}
		return false;
	}

	public boolean hasBook(int i) {
		for(Book b:bookInventory) {
			if(b.getBookID() == i) {
				return true;
			}
			
		}
		return false;
		
	
	}

}
