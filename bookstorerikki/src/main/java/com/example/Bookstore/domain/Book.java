package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String year1;
	private String isbn;
	private String price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book() {}
	
	public Book(String title, String author, String year1, String isbn, String price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year1 = year1;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
		
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
	public String getYear1() {
		return year1;
	}
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
	if (this.category != null) {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year1=" + year1 + ", isbn=" + isbn
				+ ", price=" + price + "category =" + this.getCategory() + "]";
	} else {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year1=" + year1 + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}
	}
}
