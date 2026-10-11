
public class Book {
	private int bookID;
	private String title;
	private String author;
	private int ISBN;
	private int totalPages;
	
	public Book(){
		
	};
	
	public Book(int b,String t,String a,int i,int p) {
		bookID = b;
		title = t;
		author = a;
		ISBN = i;
		totalPages = p;
		
	};
	
	public int getBookID() {
		return this.bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
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
	public int getISBN() {
		return this.ISBN;
	}
	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public void printBookInfo(Book book) {
		System.out.println("Book ID: "+book.bookID + "\nBook Title: "+book.title+"\nBook Author: "+book.author+"\nBook ISBN number: "+book.ISBN+"\nBook Total Pages: "+book.totalPages+"\n\n");
		
	}

}
