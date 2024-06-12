package com;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.config.AppConstants;
import com.entity.Role;
import com.repository.RoleRepo;

@SpringBootApplication
public class Product1Application implements CommandLineRunner{

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(Product1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");
			
			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_USER");
			
			List<Role> roles = List.of(role,role1);
			
			List<Role> result = this.roleRepo.saveAll(roles);
			
//			result.forEach(r -> System.out.println(r.getName()));
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
