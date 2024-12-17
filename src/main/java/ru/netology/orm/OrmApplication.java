package ru.netology.orm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class OrmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application launched successfully!");
	}
}
