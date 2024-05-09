//package Project;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Scanner;
//
//class Library {
//	String title;
//	String author;
//	int ISBN;
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public int getIsbn() {
//		return ISBN;
//	}
//
//	public void setIsbn(int ISBN) {
//		this.ISBN = ISBN;
//	}
//
//	public Library(String title, String author, int ISBN) {
//		super();
//		this.title = title;
//		this.author = author;
//		this.ISBN = ISBN;
//	}
//
//	@Override
//	public String toString() {
//		return "Library title=" + title + ", ename=" + author + ", ISBN=" + ISBN;
//	}
//
//}
//
//public class LibraryTask {
//	public static void main(String[] args) {
//		List<Library> c = new ArrayList<Library>();
//		Scanner sc = new Scanner(System.in);
//		Scanner sc1 = new Scanner(System.in);
//		int ch;
//		do {
//			System.out.println("1.Insert");
//			System.out.println("2.Display");
//			System.out.println("3.Search");
//			System.out.println("4.Delete");
//			System.out.println("2.Update");
//			System.out.println("Enter a number : ");
//			ch = sc.nextInt();
//			switch (ch) {
//			case 1:
//				System.out.println("---------------------------");
//				System.out.print("Enter Title name : ");
//				String title = sc1.nextLine();
//
//				System.out.print("Enter author name : ");
//				String author = sc1.nextLine();
//
//				System.out.print("Enter Isbn : ");
//				int ISBN = sc.nextInt();
//				c.add(new Library(title, author, ISBN));
//				break;
//			case 2:
//				System.out.println("---------------------------");
//				Iterator<Library> i = c.iterator();
//				while (i.hasNext()) {
//					Library e = i.next();
//					System.out.println(e);
//				}
//				System.out.println("---------------------------");
//
//				break;
//			case 3:
//				boolean found = false;
//				System.out.println("Enter a title to search : ");
//				String title1 = sc1.nextLine();
//				System.out.println("---------------------------");
//				i = c.iterator();
//				while (i.hasNext()) {
//					Library e = i.next();
//					if (e.getTitle() == title1) {
//						System.out.println(e);
//						found = true;
//					}
//				}
//				
//				if (!found) {
//					System.out.println("Record id not found . ");
//				}System.out.println("---------------------------");
//				break;
//			case 4:
//				found = false;
//				System.out.println("Enter a Emno to Delete : ");
//				title1 = sc.nextLine();
//				System.out.println("---------------------------");
//				i = c.iterator();
//				while (i.hasNext()) {
//					Library e = i.next();
//					if (e.getTitle() == title1) {
//						i.remove();
//						found = true;
//					}
//				}
//				System.out.println("---------------------------");
//				if (!found) {
//					System.out.println("Record id not found . ");
//				} else {
//					System.out.println("Record Deleted Succesfully");
//				}
//				break;
//			}
//		} while (ch != 0);
//	}
//
//}
