package com.example.ramiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ramiro.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}
