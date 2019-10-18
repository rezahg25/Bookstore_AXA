package com.reza.bookstore.axa.model;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_books")
@EntityListeners(AuditingEntityListener.class)

public class Book implements Serializable {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long bookID;

	@NotBlank
	private String titleBook;

	@NotBlank
	private String authorsName;

	@NotBlank
	private String genreBook;
	
	@NotBlank
	private String publisherBook;

	@NotBlank
	private String publicationYear;
	
	@NotBlank
	private String priceBook;

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public String getAuthorsName() {
		return authorsName;
	}

	public void setAuthorsName(String authorsName) {
		this.authorsName = authorsName;
	}


	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(String priceBook) {
		this.priceBook = priceBook;
	}

	public String getGenreBook() {
		return genreBook;
	}

	public void setGenreBook(String genreBook) {
		this.genreBook = genreBook;
	}

	public String getPublisherBook() {
		return publisherBook;
	}

	public void setPublisherBook(String publisherBook) {
		this.publisherBook = publisherBook;
	}

}
