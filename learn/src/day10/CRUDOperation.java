package day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Employee {
	int eno;
	String ename;
	int salary;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(int eno, String ename, int salary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee eno=" + eno + ", ename=" + ename + ", salary=" + salary;
	}

}

public class CRUDOperation {
	public static void main(String[] args) {
		List<Employee> c = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("2.Update");
			System.out.println("Enter a number : ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("---------------------------");
					System.out.print("Enter emp number : ");
				int eno = sc.nextInt();

				System.out.print("Enter emp name : ");
				String ename = sc1.next();

				System.out.print("Enter emp salary : ");
				int salary = sc.nextInt();
				c.add(new Employee(eno, ename, salary));
				break;
			case 2:
				System.out.println("---------------------------");
				Iterator<Employee> i = c.iterator();
				while (i.hasNext()) {
					Employee e = i.next();
					System.out.println(e);
				}
				System.out.println("---------------------------");

				break;
			case 3:
				boolean found = false;
				System.out.println("Enter a Emno to search : ");
				int emno = sc.nextInt();
				System.out.println("---------------------------");
				i = c.iterator();
				while (i.hasNext()) {
					Employee e = i.next();
					if (e.getEno() == emno) {
						System.out.println(e);
						found = true;
					}
				}
				System.out.println("---------------------------");
				if (!found) {
					System.out.println("Record id not found . ");
				}
				break;
			case 4:
				found = false;
				System.out.println("Enter a Emno to Delete : ");
				emno = sc.nextInt();
				System.out.println("---------------------------");
				i = c.iterator();
				while (i.hasNext()) {
					Employee e = i.next();
					if (e.getEno() == emno) {
						i.remove();
						found = true;
					}
				}
				System.out.println("---------------------------");
				if (!found) {
					System.out.println("Record id not found . ");
				} else {
					System.out.println("Record Deleted Succesfully");
				}
				break;

			case 5:
				found = false;
				System.out.println("Enter a Emno to Update : ");
				emno = sc.nextInt();
				System.out.println("---------------------------");
				ListIterator<Employee> li = c.listIterator();
				i = c.iterator();
				while (i.hasNext()) {
					Employee e = li.next();
					if (e.getEno() == emno) {
						System.out.println("Enter a new name ");
						ename = sc1.nextLine();
						System.out.println("Enter a new Salary");
						salary = sc.nextInt();
						li.set(new Employee(emno, ename, salary));
						found = true;
					}
				}
				System.out.println("---------------------------");
				if (!found) {
					System.out.println("Record id not found . ");
				} else {
					System.out.println("Record Deleted Succesfully");
				}
				break;

			}
		} while (ch != 0);
	}

}
