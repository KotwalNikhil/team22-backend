package com.db.grad.javaapi.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "book_name")
    private String bookName;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_user",
    	joinColumns = {@JoinColumn(name = "books_id")},
    	inverseJoinColumns = { @JoinColumn (name = "users_id")})
    		
    private Set<User> users = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL)
   	@JoinColumn( name = "book_id", referencedColumnName = "book_id")
    List<Trade> trades = new ArrayList<>();
    public Book() {
    	
    }
	public Book(long bookId, @NotNull String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
    
    
}
