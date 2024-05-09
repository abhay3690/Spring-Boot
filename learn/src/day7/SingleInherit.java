package day7;

class Principal {
	String name;
	int id;
	String address;

	public void Staff() {
		System.out.println("Your Staff");
	}
}

class teeacher extends Principal {
	public void students() {
		System.out.println("Your Student");
	}
}

public class SingleInherit {
	public static void main(String[] args) {
		teeacher p = new teeacher();
		p.Staff();
//p.students();
	}
}
