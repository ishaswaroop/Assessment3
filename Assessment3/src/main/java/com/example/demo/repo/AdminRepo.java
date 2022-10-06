package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Admin;



public interface AdminRepo extends JpaRepository<Admin, Long> {

}