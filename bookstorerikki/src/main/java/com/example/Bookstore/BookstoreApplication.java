package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("few categories");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Drama"));
			
			log.info("save a few books");
			brepository.save(new Book("J.K. Rowling", "Harry Potter",  "1999", "324253", "24.5", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Kari Hotakainen", "Juoksuhaudantie", "2002", "324253", "24.00", crepository.findByName("Drama").get(0)));
			brepository.save(new Book("J. R. R. Tolkien", "The Two Towers", "1954", "998331", "29.00", crepository.findByName("Fantasy").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
