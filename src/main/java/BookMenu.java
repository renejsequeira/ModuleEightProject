import java.util.*;
public class BookMenu {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int option = 0; // Initialized to 0 for the loop condition
		boolean input = true;
		String response = "";
		int bookID;
		String title;
		String author;
		int ISBN;
		int pages;
		
		Inventory inventory = new Inventory();
		
		
		do {
			// Printing the menu inside the loop so it reappears after an action finishes
			System.out.println("\n1.Add Book\t\t3.Return Book\t\t5.Print All Books\n" +
			                   "2.Borrow Book\t\t4.Search By Title\t6.Exit");
			
			try {
				System.out.println("Enter a menu option: ");
				option = kb.nextInt();
				kb.nextLine(); // Clear buffer
			
				if (option < 1 || option > 6) {
					System.out.println("Wrong menu option. Enter a number from 1 to 6");
				} else {
					switch (option) {
						case 1:
							while (input) {
								try {
									System.out.println("Enter book ID, book title, author, ISBN number, and number of pages:");
									bookID = kb.nextInt();
									kb.nextLine(); // Clear buffer after int
									title = kb.nextLine();
									author = kb.nextLine();
									
									ISBN = kb.nextInt();
									pages = kb.nextInt();
									kb.nextLine(); // Clear buffer after ints
									
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
									kb.nextLine(); // Clear buffer
									
									if (response.equalsIgnoreCase("yes")) {
										input = true;
									} else {
										input = false;
									}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input. Enter the correct book information.");
									kb.nextLine(); // Clear bad input from buffer
									input = true;
								}
							}
							
							input = true; // Reset input flag for future use
							break;
							
						case 2:
							while (input) {
								try {
									boolean borrow;
									System.out.println("Enter ID of book to be borrowed:");
									// Your case 2 logic continues here...
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
									input = false; // Placeholder break out of internal loop
								} catch (InputMismatchException e) {
									System.out.println("Invalid Book ID. Book not found in database");
									kb.nextLine();
								}
							}
							input = true; // Reset input flag
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
							// Handle search by title
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
				kb.nextLine(); // Clear the invalid input from scanner buffer
				option = 0;    // Reset option so loop continues safely
			}
			
		} while (option != 6); // Loop exits only when option is 6
		
		kb.close(); // Close scanner when program terminates
	}
}


