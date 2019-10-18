package com.reza.bookstore.axa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reza.bookstore.axa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitleBook(String titleBook);
	List<Book> findByAuthorsName(String authorsName);
	List<Book> findByGenreBook(String genreBook);
	List<Book> findBypublisherBook(String publisherBook);

}
