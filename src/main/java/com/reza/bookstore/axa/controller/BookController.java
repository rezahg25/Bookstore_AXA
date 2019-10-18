package com.reza.bookstore.axa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reza.bookstore.axa.model.Book;
import com.reza.bookstore.axa.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/all")
	public List<Book> getAll(){
	return bookRepository.findAll();
	}
	
	@PostMapping("/input")
	public Book addbook(@Valid @RequestBody Book book) {
	return bookRepository.save(book); }
	
	@PutMapping("/update/{bookID}")
	public ResponseEntity<Book> updateBook(@PathVariable(value="bookID")Long bookID,
	@Valid @RequestBody Book detailbook){
		
		Optional<Book> book = bookRepository.findById(bookID);
		
		if(book == null)
			return ResponseEntity.notFound().build();
		
		Book updateBook = bookRepository.save(book.get());
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/delete/{bookID}")
	public String deleteBook(@PathVariable (value="bookID") Long bookID) {
		Optional<Book> book = bookRepository.findById(bookID);
		String result = "";
		if(book == null) {
			result = "bookID "+bookID+" not found";
			return result;
		}
		result = "bookID "+bookID+" deleted";
		bookRepository.deleteById(bookID);
		return result;
	}
	
	@GetMapping("/title/{titleBook}")
	public List<Book> title(@PathVariable(value="titleBook")String titleBook){
		return bookRepository.findByTitleBook(titleBook);
	}
	
	@GetMapping("/authorsname/{authorsName}")
	public List<Book> authorsname(@PathVariable(value="authorsName")String authorsName){
		return bookRepository.findByAuthorsName(authorsName);
	}
	
	@GetMapping("/genre/{genreBook}")
	public List<Book> genre(@PathVariable(value="genreBook")String genreBook){
		return bookRepository.findByGenreBook(genreBook);
	}
}
