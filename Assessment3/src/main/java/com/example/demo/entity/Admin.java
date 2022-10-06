package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	long id;
	@Column(name="address")
	String address;
	@Column(name="name")
	String name;
	@Column(name="password")
	String password;
	@OneToMany
	 List<Book>book;
	public Admin(long id, String address, String name, String password, List<Book> book) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.password = password;
		this.book = book;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", address=" + address + ", name=" + name + ", password=" + password + ", book="
				+ book + "]";
	}
}