package day11;

import java.util.*;
import java.sql.*;

public class JDBC {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example_database", "root",
				"Abhay@3690");
		System.out.println("Connection created");
//select
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select * from example_table ");
//		while (rs.next()) {
//			int Id = rs.getInt("age");
//			String Name = rs.getString("name");
//			int Age = rs.getInt("age");
//			String Email = rs.getString("email");
//			String Address = rs.getString("address");
//
//			System.out.println(Id + " " + Name + " , " + Age + " , " + Email + " , " + Address);
//		}

//		st.close();
//inserted
//		String q ="insert into example_table values (15,'abhay',55,'abhay.suthar@gmail.com','new York')";
//		PreparedStatement p = con.prepareStatement(q);
//		p.execute();
//		System.out.println("DAta Inserted");
//updated
//		String q2 ="update example_table set name = 'abhay suthar' where id=2 ";
//		PreparedStatement p1 = con.prepareStatement(q2);
//		p1.execute();
//		System.out.println("DAta updated");
//Deleted
//		String q3 ="delete from example_table where id = 3";
//		PreparedStatement p3 = con.prepareStatement(q3);
//		p3.execute();
//		System.out.println("DAta deleted");
		con.close();
	}
}
