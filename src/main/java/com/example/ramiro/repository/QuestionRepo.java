package com.example.ramiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ramiro.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}