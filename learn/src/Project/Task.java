package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
	private String title;
	private String author;
	private String ISBN;

	public Book(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
	}
}

class Library {
	private List<Book> books;

	public Library() {
		books = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added successfully!");
	}

	public void displayBooks() {
		if (books.isEmpty()) {
			System.out.println("The library is empty.");
		} else {
			System.out.println("Books in the library:");
			for (Book book : books) {
				System.out.println(book);
			}
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Book found\n" + book);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Book not faumf in the library.");
		}
	}

	public void removeBook(String ISBN) {
		boolean removed = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getISBN().equals(ISBN)) {
				books.remove(i);
				System.out.println("Book removed successfully!");
				removed = true;
				break;
			}
		}
		if (!removed) {
			System.out.println("Book with ISBN " + ISBN + " not found in the library.");
		}
	}
}

public class Task {
	public static void main(String[] args) {
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\nLibrary Menu:");
			System.out.println("1. Add a new book .");
			System.out.println("2. Display all books .");
			System.out.println("3. Search for a book ");
			System.out.println("4. Remove a book .");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
			case 1:
				System.out.print("Enter title: ");
				String title = scanner.nextLine();
				System.out.print("Enter author: ");
				String author = scanner.nextLine();
				System.out.print("Enter ISBN: ");
				String ISBN = scanner.nextLine();
				library.addBook(new Book(title, author, ISBN));
				break;
			case 2:
				library.displayBooks();
				break;
			case 3:
				System.out.print("Enter title to search: ");
				String searchTitle = scanner.nextLine();
				library.searchByTitle(searchTitle);
				break;
			case 4:
				System.out.print("Enter ISBN of the book to remove: ");
				String removeISBN = scanner.nextLine();
				library.removeBook(removeISBN);
				break;
			case 5:
				System.out.println("Exiting the program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");
			}
		} while (choice != 5);


	}
}
