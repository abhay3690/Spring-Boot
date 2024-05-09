package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.w3c.dom.ls.LSInput;

import com.jpa.test.dao.Abhay;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjapaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjapaexampleApplication.class, args);
		Abhay abhay = context.getBean(Abhay.class);

//		User user = new User();
//		user.setName("Abhay");
//		user.setCity("Ahmdabad");
//		user.setStatus("Spring");

//		User user1 = new User();
//		user1.setName("gaurang");
//		user1.setCity("Ahmdabad");
//		user1.setStatus("Spring");
//		List<User> users = List.of(user, user1);
		// SAve Multiple of object
//		Iterable<User> result = abhay.saveAll(users);
//		result.forEach(use -> {
//			System.out.println(use);
//		});
		// Saving single user
////		User user2 =abhay.save(user);
//
////		System.out.println("Printed succesfully" + user2);
//		System.out.println("Done");

		// update user id:352
//		Optional<User> optional = abhay.findById(353);
//		User user = optional.get();
//		user.setName("Hello  World");
//		User result = abhay.save(user);
//		System.out.println(user.getId()+" "+user.getName()+" "+user.getStatus());
//		System.out.println(result);

		// How to get data
//		findByID(id);
//		Iterable<User> itr = abhay.findAll();
//		Iterator<User> iterator = itr.iterator();	
//		while(iterator.hasNext()) {
//			
////			iterator.forEachRemaining(s->System.out.println(s));
//			
//		}
//		iterator.forEachRemaining(s->System.out.println(s));

		// Deleting the user element
//	abhay.deleteById(352);
//	System.out.println("deleted");
//	Iterable<User> allusers = abhay.findAll();
//	allusers.forEach(user->System.out.println(user));
//	abhay.deleteAll(allusers);

//		user.java 
//		List<User> users = abhay.findByName("abhay");

//		List<User> users = abhay.findByNameAndCity("abhay","Ahmdabad");
//		users.forEach(e -> System.out.println(e));

//		List<User> users = abhay.findByNameStartingWith("g");
//		users.forEach(e-> System.out.println(e));

//		List<User> users = abhay.findByNameEndingWith("g");
//		users.forEach(e-> System.out.println(e));

//		 error  User users = abhay.findByNameContaining("g");
//		error   users.forEach(e-> System.out.println(e));
		try {
			List<User> u = abhay.findByNameContaining("a");
			u.forEach(e -> System.out.println(e));
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("data not found");
		} finally {
			System.out.println("gaurang done");
		}

//		List<User> 

	}
}