package com.example.jdbc_demo;

import com.example.jdbc_demo.models.Category;
import com.example.jdbc_demo.models.Product;
import com.example.jdbc_demo.repositories.CategoryRepository;
import com.example.jdbc_demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//code for console app goes here
		Scanner scanner = new Scanner(System.in);

		List<Category> categoryList = categoryRepository.getAllCategories();
		System.out.println("Categories:");
		categoryList.forEach(System.out::println);

		System.out.print("Enter the category ID to view products: ");
		int categoryId = scanner.nextInt();

		List<Product> products = productRepository.getProductsByCategoryId(categoryId);
		System.out.println("Products in category ID " + categoryId + ":");
		products.forEach(System.out::println);
	}
}
