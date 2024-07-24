package com;

import com.config.AppConstatns;
import com.modal.Role;
import com.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
@RequiredArgsConstructor
@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    private final  RoleRepo roleRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        System.out.println("this is Main Check");
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
            role1.setName("ROLE_USER");

            List<Role> roles = List.of(role,role1);

            List<Role> result = this.roleRepo.saveAll(roles);

            result.forEach(r -> System.out.println(r.getName()));

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }


}
