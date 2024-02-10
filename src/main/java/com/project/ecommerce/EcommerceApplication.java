package com.project.ecommerce;

import com.project.ecommerce.entity.ERole;
import com.project.ecommerce.entity.Role;
import com.project.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	 CommandLineRunner initRoles(RoleRepository roleRepository) {
		return args -> {
			for (ERole role : ERole.values()) {
				if (roleRepository.findByName(role).isEmpty()) {
					Role newRole = new Role();
					newRole.setName(role);
					roleRepository.save(newRole);
				}
			}
		};
	}
}
