package com;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.config.AppConstatns;

@SpringBootApplication
public class ProductApplication {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		System.out.println("this is Main Check");
		return new ModelMapper();
	}
//	@Override
//	public void run(String... args) throws Exception {
////		System.out.println(this.passwordEncoder.encode("4521"));
//		try {
//			Role role = new Role();
//			role.setId(AppConstatns.NORMAL_PRODUCT);
//			role.setName("ROLE_PRODUCT");
//			
//			Role role1 = new Role();
//			role1.setId(AppConstatns.SELLER_USER);
//			role1.setName("ROLE_SELLER");
//			
//			List<Role> roles = List.of(role,role1);
//			
//			List<Role> result = this.roleRepo.saveAll(roles);
//			
////			result.forEach(r -> System.out.println(r.getName()));
//	
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

}
