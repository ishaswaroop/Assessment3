package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepo repo;
	
	
	@GetMapping("/")
	public List<Book> showBook()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	@GetMapping("/id/{id}")
	public Book getBook(@PathVariable int id) {
		return repo.findById(id).get();
		
	}
	@GetMapping("/name/{name}")
	public List<Book> getBook(@PathVariable String name) {
		return repo.findByName(name);
		
	}
	@GetMapping("/price/{price}")
	public List<Book> getBook(@PathVariable double price) {
		return repo.findByPrice(price);
		
	}
	@GetMapping("/quantity/{quantity}")
	public List<Book> getBook1(@PathVariable int quantity){
		return repo.findByQuantity(quantity);
	}
	
	
	
	@PostMapping("/")
	public Book saveBook(@RequestBody Book  emp)
	{
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	//it is use to update the resource on the server
	
	@PutMapping("/")
	public Book updateBook(@RequestBody Book  emp)
	{
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		System.err.println("deleted id is : "+id);
		repo.deleteById(id);
		return "Record Has been deleted !";
	}
	
	
}