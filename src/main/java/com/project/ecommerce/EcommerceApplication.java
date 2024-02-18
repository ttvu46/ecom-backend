package com.project.ecommerce;

import com.project.ecommerce.entity.ERole;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.Role;
import com.project.ecommerce.repository.ProductRepository;
import com.project.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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

	// inject some products to database.
	@Bean
	CommandLineRunner initProductTable(ProductRepository productRepo){
		List<Product> lst = new ArrayList<>();
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product1.jpg", "Product 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 1.23 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product2.jpg", "Product 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 2.45 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product3.jpg", "Product 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 7.89 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product4.png", "Product 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 9.45 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product5.jpg", "Product 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 2.12));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product6.jpg", "Product 6", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 5.67 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product7.jpg", "Product 7", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 7.89 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product8.jpg", "Product 8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 9.34 ));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product9.jpg", "Product 9", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 4.45));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product10.png", "Product 10", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 6.55));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product11.png", "Product 11", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 7.45));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product12.png", "Product 12", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 8.46));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product13.png", "Product 13", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 8.45));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product14.png", "Product 14", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 10.45));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product15.png", "Product 15", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 6.78));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product16.png", "Product 16", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 8.25));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product17.png", "Product 17", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 13.45));
		lst.add(new Product("https://ecom-thanh.s3.us-west-2.amazonaws.com/images/product18.png", "Product 18", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ", 7.35));
		return args -> {
			for(Product product: lst){
				if(productRepo.findByUrl(product.getUrl()).isEmpty())
					productRepo.save(product);
			}
		};
	}
}
