import java.util.*;
public class BookMenu {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int option = 0; 
		boolean input = true;
		String response = "";
		int bookID;
		String title;
		String author;
		int ISBN;
		int pages;
		
		Inventory inventory = new Inventory();
		
		
		do {
			
			System.out.println("\n1.Add Book\t\t3.Return Book\t\t5.Print All Books\n" +
			                   "2.Borrow Book\t\t4.Search By Title\t6.Exit");
			
			try {
				System.out.println("Enter a menu option: ");
				option = kb.nextInt();
				kb.nextLine(); 
			
				if (option < 1 || option > 6) {
					System.out.println("Wrong menu option. Enter a number from 1 to 6");
				} else {
					switch (option) {
						case 1:
							while (input) {
								try {
									System.out.println("Enter book ID, book title, author, ISBN number, and number of pages:");
									bookID = kb.nextInt();
									kb.nextLine(); 
									title = kb.nextLine();
									author = kb.nextLine();
									
									ISBN = kb.nextInt();
									pages = kb.nextInt();
									kb.nextLine(); 
									
									if (inventory.idDuplicate(bookID)) {
										System.out.println("Duplicate Book ID. Enter unique Book ID");
										continue;
									}
									
									if (inventory.isbnDuplicate(ISBN)) {
										System.out.println("Duplicate ISBN number. Enter unique ISBN number.");
										continue;
									}
									
									inventory.addBook(bookID, title, author, ISBN, pages);
									System.out.println("Book added to the Library.");
									
									System.out.println("Need to add more books: enter yes or no");
									response = kb.next();
									kb.nextLine();
									
									if (response.equalsIgnoreCase("yes")) {
										input = true;
									} else {
										input = false;
									}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input. Enter the correct book information.");
									kb.nextLine(); 
									input = true;
								}
							}
							
							input = true; 
							break;
							
						case 2:
							while (input) {
								try {
									boolean borrow;
									System.out.println("Enter ID of book to be borrowed:");
								
									int ID = kb.nextInt();
									
									kb.nextLine();
									borrow = inventory.borrowBook(ID);
								
									if (borrow) {
										System.out.println("Book successfully borrowed!");
										
									}else if(inventory.bookBorrow(ID)) {
										System.out.println("Book already borrowed!");
									}
									else if (!inventory.hasBook(ID)) { 
										System.out.println("Book not found in database.");
									} 
									input = false; 
								} catch (InputMismatchException e) {
									System.out.println("Invalid Book ID. Book not found in database");
									kb.nextLine();
								}
							}
							input = true; 
							break;
							
						case 3:
							while(input) {
								try {
									boolean returned;
									System.out.println("Enter ID of returned book:");
									int ID = kb.nextInt();
									kb.nextLine();
									returned = inventory.returnBook(ID);
								
									if(returned) {
										System.out.println("Book successfully returned!");
									}
									else if (inventory.hasBook(ID)) { 
										System.out.println("Book already returned to database.");
									}
									else if(!returned){
										System.out.println("Error, Book is not found.");
									}
									
									input = false;
								}catch(InputMismatchException e) {
								
									System.out.println("Invalid Book ID. Enter correct book ID.");
									kb.nextLine();
							}
							}
							input=true;
							break;
							
						case 4:
							try {
							LinkedList<Book> bookTitle = new LinkedList<>();
							String bt="";
							System.out.println("Enter book title or partial title to search in Library database:");
							bt = kb.nextLine();
							bookTitle =inventory.searchByTitle(bt);
							if(bookTitle.isEmpty()) {
								System.out.println("No matching titles found.");
							}
							for(Book t:bookTitle) {
								System.out.println("Matching book titles: "+ t );
							}
							}catch(InputMismatchException e) {
								System.out.println("Invalid Book title format. Enter correct or partial book title.");
								kb.nextLine();
							}
							input = true;
							break;
							
						case 5:
							inventory.printAll();
							
							break;
							
						case 6:
							System.out.println("Exiting the Library System. Goodbye!");
							break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid option type. Please enter a valid number.");
				kb.nextLine(); 
				option = 0;   
			}
			
		} while (option != 6); 
		
		kb.close(); 
	}
}


