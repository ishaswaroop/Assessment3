package com.example.demo.controller;

import java.util.ArrayList;
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


import com.example.demo.entity.Admin;
import com.example.demo.entity.Book;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.BookRepo;



@RestController
@RequestMapping("/home")
public class AdminController {

	@Autowired
	AdminRepo repo;
	
	@Autowired
	BookRepo brepo;
	
	@GetMapping("/")
	public List<Admin> showAdmin()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	
	
	@PostMapping("/")
	public Admin saveAdmin(@RequestBody Admin  emp)
	{
		List<Book>add=new ArrayList<>();
		for(Book a:emp.getBook()) {
			Book book=brepo.findById(a.getId()).get();
			add.add(book);
		}
		emp.setBook(add);
       repo.save(emp);
		
		return emp;
	}
	
	//it is use to update the resource on the server
	
	@PutMapping("/")
	public Admin updateAdmin(@RequestBody Admin emp)
	{
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	
	//delete : it is used to delete the resource on the server
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable("id") long id)
	{
		System.err.println("deleted id is : "+id);
		repo.deleteById(id);
		return "Record Has been deleted !";
	}
	
	
}