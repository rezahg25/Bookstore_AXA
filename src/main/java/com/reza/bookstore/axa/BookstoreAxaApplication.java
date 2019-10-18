package com.reza.bookstore.axa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookstoreAxaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreAxaApplication.class, args);
	}

}
