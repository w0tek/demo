package com.example.demo.book.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="tab", initialValue=3, allocationSize=50)
public class BookDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	private Long id;

	private String title;
	private String author;
	private String isbn;

	public BookDTO() {
	}

	public BookDTO(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "<br>Book id=" + id + ", title=" + title + ", author=" + author + ", ISBN=" + isbn;
	}

}
