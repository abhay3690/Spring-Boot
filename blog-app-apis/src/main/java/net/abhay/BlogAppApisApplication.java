package net.abhay;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.abhay.config.AppConstatns;
import net.abhay.entities.Role;
import net.abhay.repositories.RoleRepo;

@SpringBootApplication
@RequiredArgsConstructor
public class BlogAppApisApplication implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;

	private final RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
		
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		try {

			Role role = new Role();
			role.setId(AppConstatns.ADMIN_USER);
			role.setName("ROLE_ADMIN");
			
			Role role1 = new Role();
			role1.setId(AppConstatns.NORMAL_USER);
			role1.setName("ROLE_NORMAL");
			
			List<Role> roles = List.of(role,role1);
			this.roleRepo.saveAll(roles);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
